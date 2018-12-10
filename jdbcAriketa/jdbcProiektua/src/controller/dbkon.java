/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DM3-2-17
 */
public class dbkon {
      //Atributuak
   static String bd = "ariketa";
   String login ="root";
   static String password ="";
   static String url = "jdbc:mysql://localhost:3306/"+bd;

   Connection conn = null;

   /** Eraikitzailea*/
   public dbkon() throws ClassNotFoundException, SQLException {
      try{
         //drivera kudeatzen...
         Class.forName("com.mysql.jdbc.Driver");
         //konexioa egiten...
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
            System.out.println("Konexioa ondo burutu da "+bd+" datubasera");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }
      /*catch(ClassNotFoundException e){
         System.out.println(e);
      }*/catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
   
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }

    void disconnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
