/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.MedicoM;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;import javax.swing.JOptionPane;

/**
 *
 * @author joelmir
 */
public abstract class MedicoDao implements Dao{
   
    public conn con = new conn();
    public void inserir(Object o) {
       MedicoM m = (MedicoM) o;
       String sql = "INSERT INTO Medico (nome,cpf,crm,especialidade,email,telefone,endereco) VALUES(?,?,?,?,?,?,?)";
       try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,m.getNome());
           ps.setString(2,m.getCpf());
           ps.setString(3,m.getCrm());
           ps.setString(4,m.getEspecialidade());
           ps.setString(5,m.getEmail());
           ps.setString(6, m.getTelefone());
           ps.setString(7, m.getEndereco());
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
        MedicoM m = (MedicoM) o;
         String sql = "UPDATE Medico SET nome=?,cpf=?,crm=?,especialidade=?,email=?,telefone=?,endereco=? WHERE idmedico=?";
         try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,m.getNome());
           ps.setString(2,m.getCpf());
           ps.setString(3,m.getCrm());
           ps.setString(4,m.getEspecialidade());
           ps.setString(5,m.getEmail());
           ps.setString(6, m.getTelefone());
           ps.setString(7, m.getEndereco());
           ps.setInt(8, m.getIdmedico());
           ps.execute();
           ps.close(); 
           JOptionPane.showMessageDialog(null,"Cadastro Atualizado!");

         } catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       } 
    }

    @Override
    public void excluir(int o) {
        String sql = "DELETE FROM Medico WHERE idmedico=" + o;
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
