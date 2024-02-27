/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.PessoaFisica;
import view.Principal;

/**
 *
 * @author joelmir
 */
public abstract class FuncionarioDao implements Dao{
    public conn con = new conn();
    
    public void inserir(Object o) {
       PessoaFisica f = (PessoaFisica) o;
       String sql = "INSERT INTO Funcionario (cpf,senha,nome,email,telefone,endereco) VALUES(?,?,?,?,?,?)";
       try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,f.getCpf());
           ps.setString(2,f.getSenha());
           ps.setString(3,f.getNome());
           ps.setString(4, f.getEmail());
           ps.setString(5, f.getTelefone());
           ps.setString(6,f.getEndereco());
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
        PessoaFisica f = (PessoaFisica) o;
         String sql = "UPDATE Funcionario SET cpf=?,senha=?,nome=?,email=?,telefone=?,endereco=? WHERE idfuncionario=?";
         try{
           PreparedStatement ps = conn.getConexao().prepareStatement(sql);
           ps.setString(1,f.getCpf());
           ps.setString(2,f.getSenha());
           ps.setString(3,f.getNome());
           ps.setString(4, f.getEmail());
           ps.setString(5, f.getTelefone());
           ps.setString(6,f.getEndereco());
           ps.setString(7,f.getIdpessoafisica());
           ps.execute();
           ps.close(); 
           JOptionPane.showMessageDialog(null,"Cadastro Atualizado!");
         } catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       } 
    }

    @Override
    public void excluir(int o) {
        String sql = "DELETE FROM Funcionario WHERE idfuncionario=" + o;
        try{
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null,"Cadastro Excluido!");
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro SQL:\n"+ex);  
       } 
    }
    
    public void VerifLogin(PessoaFisica u){
        String sql = "SELECT cpf,senha FROM Funcionario WHERE cpf=? AND senha=?";
        try{
            PreparedStatement ps =conn.getConexao().prepareStatement(sql);
            ps.setString(1,u.getCpf());
            ps.setString(2, u.getSenha());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                        /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Principal().setVisible(true);
                    }
                });
                
            }else{
                JOptionPane.showMessageDialog(null,"Usuário ou Senha inválido!");
            }
         
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
}
