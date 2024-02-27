/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joelmir
 */
public class Conexao {
    public static void main(String[] args) {
        
    String url = "jdbc:mysql://localhost:3306/ClinicaMedica";
    //String url = "jdbc:postgresql://localhost:5432/cliente";
    String NomeUser = "root";
    String Senha = "";
    String classForName="com.mysql.cj.jdbc.Driver";
    //String classForName="org.postgresql.Driver";
   try
        {
           // O método forName carrega e inicia o driver passado por parâmetro
           Class.forName(classForName);
            // Estabelecendo a conexão
   	   Connection MinhaConexao = DriverManager.getConnection(url, NomeUser, Senha);
           
           JOptionPane.showMessageDialog(null,"Conexão realizada com sucesso");
         
        }catch(ClassNotFoundException ex){
             JOptionPane.showMessageDialog(null,"Driver JDBC-MYSQL não encontrado! "+ ex);
         }
        catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Problemas na conexao com a fonte de dados");
        } 
    }
}
