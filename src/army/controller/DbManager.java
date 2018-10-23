package army.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import army.settings.Settings;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbManager {
  static  Connection con=null;
    public static Connection getConnection() throws Exception{
    try{
   	// 1.get a connection to Database 
//        Class.forName(Settings.DBDriver);
        return DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);

                                  }catch (SQLException ex) {
		
                         JOptionPane.showMessageDialog(null, "not connected");
                          JOptionPane.showMessageDialog(null , ex.getMessage());
                         return null;}
    }   

   
    public static void CloseConnection(){
    
        if (con != null) {
        try { 
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

public static Vector executeQuery(String input){
      return null;

}
}
