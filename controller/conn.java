  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author joelmir
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conn {
   static String url = "jdbc:mysql://localhost/ClinicaMedica";
   static String usuario = "root";
   static String senha = "";
   static Connection con;
   static String classforName = "com.mysql.cj.jdbc.Driver";

//abaixo um metodo de conexão
   //trows - um trecho de código que chame este método deve 
   //obrigatoriamente capturar uma possível exceção que ele lance
public static Connection getConexao() throws SQLException{
  try{
      //abaixo o Class.forName tem a função de encontrar o connector 
      //driver mysql 
    Class.forName(classforName);
     if(con == null){
     con = (Connection) DriverManager.getConnection(url, usuario, senha);
    }
   return con;
   
  }catch(ClassNotFoundException e){
   throw new SQLException(e.getMessage());
  }
 }
 //abaixo um metodo para fechar a conexão
    public void FecharConexao() {
      if (con != null) {
        try {
          con.close();
          JOptionPane.showMessageDialog(null,"Fechou");
        } catch (SQLException e) {
           e.printStackTrace();
        }
      }
      
    }
 }

