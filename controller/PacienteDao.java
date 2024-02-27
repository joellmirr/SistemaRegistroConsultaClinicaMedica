/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.PessoaFisica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joelmir
 */
public abstract class PacienteDao implements Dao{
   
    public conn con = new conn();
    public void inserir(Object o) {
       PessoaFisica p = (PessoaFisica) o;
       String sql = "INSERT INTO Paciente (nome,cpf,email,telefone,endereco) VALUES(?,?,?,?,?)";
       try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,p.getNome());
           ps.setString(2,p.getCpf());
           ps.setString(3,p.getEmail());
           ps.setString(4, p.getTelefone());
           ps.setString(5, p.getEndereco());
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
        PessoaFisica p = (PessoaFisica) o;
         String sql = "UPDATE Paciente SET nome=?,cpf=?,email=?,telefone=?,endereco=? WHERE idpaciente=?";
         try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,p.getNome());
           ps.setString(2,p.getCpf());
           ps.setString(3,p.getEmail());
           ps.setString(4, p.getTelefone());
           ps.setString(5, p.getEndereco());
           ps.setString(6, p.getIdpessoafisica());
           ps.execute();
           ps.close(); 
           JOptionPane.showMessageDialog(null,"Cadastro Atualizado!");

         } catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       } 
    }

    @Override
    public void excluir(int o) {
        String sql = "DELETE FROM Paciente WHERE idpaciente=" + o;
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
