
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class Connectionfactory {
   private  static final String DRIVER  = "com.mysql.jdbc.Driver";
   private  static final String URL    = "jdbc:mysql://localhost:3306/automacao"; 
   private  static final String USER   = "root";
   private  static final String SENHA  = "1404";
     
     
     
   public static Connection getConnection() {
      try {
         Class.forName(DRIVER);
             
         return DriverManager.getConnection(URL, USER, SENHA);
      } 
      catch (ClassNotFoundException | SQLException ex) {
         throw  new RuntimeException("erro na conexão" + ex);
      }
   } 
     
   public static void fechaConection ( Connection con){
      try { 
         if( con != null){
            con.close();
         } 
      } 
      catch (SQLException ex) {
         Logger.getLogger(Connectionfactory.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("erro " + ex);
      
      }    
   }
   public static void fechaConection ( Connection con, PreparedStatement stm){
         
      fechaConection(con);
      try {
         if(stm != null){
            stm.close();
         }
      } 
      catch (SQLException ex) {
         Logger.getLogger(Connectionfactory.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("erro " + ex);
      
      }
   }
       
   public static void fechaConection ( Connection con, PreparedStatement stm , ResultSet rs){
         
      fechaConection(con, stm);
      try {
         if(rs != null){
            rs.close();
         }
      } 
      catch (SQLException ex) {
         Logger.getLogger(Connectionfactory.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("erro " + ex);
      }
   }
            
}
