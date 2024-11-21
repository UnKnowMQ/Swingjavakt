/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unknown.ontap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sach;
import model.SachDAO;
import view.GUI;
import view.Table;

/**
 *
 * @author Admin
 */
class newThreadserver extends Thread{
    private Socket cl ;
    private InetAddress a_client;
    private int count;
    private int p_client;
    //Nhan sach chuyen len Database
    private Sach s;
    //Input
    //oup
    ObjectInputStream inp;
    ObjectOutputStream oup;
    BufferedReader input_request;
    BufferedReader id;

    public newThreadserver(Socket cl,int count) {
        super();
        this.count = count;
        this.cl = cl;
        start();
    }

    public void run(){
        try {
            
            inp = new ObjectInputStream(cl.getInputStream());
            oup = new ObjectOutputStream(cl.getOutputStream());
            s = (Sach) inp.readObject();
            input_request = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            String re = input_request.readLine();
            String id = input_request.readLine();
            System.out.println(re);
                if(re.equalsIgnoreCase("add"))
                    SachDAO.getInstance().add(s);
                if(re.equalsIgnoreCase("delete"))
                    SachDAO.getInstance().detele(id);
                    
//            else if(){
//                
//            }
            
            Table t = new Table();
            t.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(newThreadserver.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(newThreadserver.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } finally{
            try {
                if(cl!= null)cl.close();
                if(inp !=null)inp.close();
                if(oup!= null)oup.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }

    }
}
public class Server {
    public static void main(String[] args) {
        ServerSocket svr = null;
        int s_port = 1234;
        Socket cl;
        int count;
        try {
            svr = new ServerSocket(s_port);
            count = 0;
            System.out.println("server is ready");
            while(true)
            {
                cl = svr.accept();
                new newThreadserver(cl, count);
                count++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                if(svr!= null)svr.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
