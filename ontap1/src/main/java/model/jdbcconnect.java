/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class jdbcconnect {
  
    public  static Connection getConnection(){
        String username = "root";
        String password = "";
        Connection cnt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/qls";
            cnt = DriverManager.getConnection(url,username,password);
            System.out.println("Connection complete!");
        } catch (SQLException ex) {
            Logger.getLogger(jdbcconnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False connection!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnt;
    }
    public static void closeConnection(Connection c)
    {
        if(c!= null)
        {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(jdbcconnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
