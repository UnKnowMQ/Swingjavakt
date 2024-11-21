/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.unknown.ontap1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sach;
import model.SachDAO;
import model.jdbcconnect;
import view.GUI;

/**
 *
 * @author Admin
 */
public class Client {

    public static void add_book(Sach a,Socket cl)
    {
        String s = "add";
        int p_server = 1234;
        String ip_server = "localhost";
        ObjectOutputStream inp  =null;
        PrintWriter p = null;
        String id = "";
        try {
         
           cl = new Socket(ip_server, p_server);
           inp = new ObjectOutputStream(cl.getOutputStream());
           inp.writeObject(a);
           p = new PrintWriter(cl.getOutputStream());
           p.print(s);
           p.print(id);
           
            
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        finally{
           
            try {
               if(p != null)p.close();
               if(cl != null) cl.close();
               if(inp != null)inp.close();
            } catch (Exception ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
      
    }

    public static void main(String[] args) {
        Socket cl = null;
        int p_server = 1234;
        String ip_server = "localhost";
        ObjectOutputStream inp ;
        PrintWriter p = null;
        String id = "";
        try {
            
            cl = new Socket(ip_server, p_server);
            inp = new ObjectOutputStream(cl.getOutputStream());
            GUI g = new GUI();
            g.setVisible(true);
            
           
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
      
    }
}
