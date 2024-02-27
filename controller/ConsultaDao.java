/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.ConsultaM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joelmir
 */
public abstract class ConsultaDao implements Dao{
   
    public conn con = new conn();
    public void inserir(Object o) {
       ConsultaM c = (ConsultaM) o;
       String sql = "INSERT INTO Consultas (paciente,dataconsulta,valorconsulta,motivoconsulta,exame,"
               + "descricaoexame,medico) VALUES(?,?,?,?,?,?,?)";
       try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setInt(1,c.getPaciente());
           ps.setString(2,c.getDataconsulta());
           ps.setFloat(3,c.getValorconsulta());
           ps.setString(4, c.getMotivoconsulta());
           ps.setString(5, c.getNomeexame());
           ps.setString(6,c.getDescricaoexame());
           ps.setInt(7,c.getMedico());
           ps.execute();
           ps.close();
           JOptionPane.showMessageDialog(null,"Cadastro Realizado!");
          // con.FecharConexao();
       }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       }
       
    }

    @Override
    public void atualizar(Object o) {
        ConsultaM c = (ConsultaM) o;
         String sql = "UPDATE Consultas SET paciente=?,dataconsulta=?,valorconsulta=?,motivoconsulta=?,exame=?,"
                 + "descricaoexame=?,medico=? WHERE idconsulta=?";
         try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setInt(1,c.getPaciente());
           ps.setString(2,c.getDataconsulta());
           ps.setFloat(3,c.getValorconsulta());
           ps.setString(4, c.getMotivoconsulta());
           ps.setString(5, c.getNomeexame());
           ps.setString(6,c.getDescricaoexame());
           ps.setInt(7,c.getMedico());
           ps.setString(8,c.getIdconsulta());
           ps.execute();
           ps.close(); 
           JOptionPane.showMessageDialog(null,"Cadastro Atualizado!");

         } catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       } 
    }

    @Override
    public void excluir(int o) {
        String sql = "DELETE FROM Consultas WHERE idconsulta=" + o;
        try{
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null,"Cadastro Excluido!");
        } catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       } 
    }
}
