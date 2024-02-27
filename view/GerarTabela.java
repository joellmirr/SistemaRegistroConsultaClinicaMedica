package view;




import controller.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GerarTabela {
    
    public void GerarTab(String sql){
        
        DefaultTableModel ModeloTabela = new DefaultTableModel();
       
        JTable tabela = new JTable(ModeloTabela);
        JFrame frame = new JFrame("Consultar");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(tabela));
        frame.pack();
        //Definir tamanho do frame
        frame.setSize(1000, 600);
        //Comando para centralizar o frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
                
        // Conectar ao banco de dados e obter dados da tabela
        try {
            //JOptionPane.showMessageDialog(null,sql);
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
                        
            // Obter informações sobre as colunas
            ResultSetMetaData metaData = rs.getMetaData();
            int colCount = metaData.getColumnCount();

            // Adicionar colunas ao modelo
            for (int i = 1; i <= colCount; i++) {
                ModeloTabela.addColumn(metaData.getColumnName(i));
            }

            // Adicionar linhas ao modelo com dados do banco de dados
            while (rs.next()) {
                Object[] rowData = new Object[colCount];
                for (int i = 1; i <= colCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                ModeloTabela.addRow(rowData);
            }
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
            //dispose();
        }
       
    }
    
    
     public void BuscarDadosTabela(String sql){
        DefaultTableModel ModeloTab = new DefaultTableModel();
        
           // Conectar ao banco de dados e obter dados da tabela
            String SQL = JOptionPane.showInputDialog("Digite:");
            try {
                //JOptionPane.showMessageDialog(null,sql);
                PreparedStatement ps = conn.getConexao().prepareStatement(sql);
                ps.setString(1, SQL);
                ResultSet rs = ps.executeQuery();
                
                if(rs.next() == true){
                    
                // Obter informações sobre as colunas
                ResultSetMetaData metaData = rs.getMetaData();
                int colCount = metaData.getColumnCount();

                // Adicionar colunas ao modelo
                for (int i = 1; i <= colCount; i++) {
                    ModeloTab.addColumn(metaData.getColumnName(i));
                }

                // Adicionar linhas ao modelo com dados do banco de dados
                while (rs.next()) {
                    Object[] rowData = new Object[colCount];
                    for (int i = 1; i <= colCount; i++) {
                        rowData[i - 1] = rs.getObject(i);
                    }
                    ModeloTab.addRow(rowData);
                }
                
                // Mensagem quando nao encontar resgistro na tabela
                if (!rs.next() && ModeloTab.getRowCount() == 0) {
                    
                    JOptionPane.showMessageDialog(null, "Nenhum Registro Encontrado.");
                    //LimparTab();
                }
                
               JTable tabela = new JTable(ModeloTab);
               JFrame frame = new JFrame("Consultar");
               frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               frame.getContentPane().add(new JScrollPane(tabela));
               frame.pack();
               frame.setSize(1000, 600);
               //Comando para centralizar o frame
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
               
               }else{
                    JOptionPane.showMessageDialog(null, "\nTente Novamente.");
                    //dispose();
                }
                               
            } catch (SQLException e) {
                e.printStackTrace();
                //dispose();
            }
            
    }
     
     public void BuscarID(){
         
         int Buscar_ID = -1;//Para receber objetodentro de um metodo,esta variavel deve ser declarada como variavel global
         
         int ID_Exemplo = -1;
        String CPF = JOptionPane.showInputDialog("Informe o CPF");
        String sql2 = "SELECT ID_tabela FROM Tabela WHERE CPF= ?";
        
        try {
            PreparedStatement ps = conn.getConexao().prepareStatement(sql2);
            ps.setString(1, CPF);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                ID_Exemplo = rs.getInt("ID_tabela");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção: " + ex.getMessage());
        }
        
        String sql = "INSERT INTO Tabela (coluna1, Coluna2, ID_tabela);VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            //ps.setInt(1, C.getcoluna1());
            //ps.setInt(2, C.getColuna2());
            //ps.setInt(3, ID_Cliente);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção: " + ex.getMessage());
        }
    }

}


    

