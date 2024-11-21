/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SachDAO implements ObjectDAO<Sach>{
    public static SachDAO getInstance(){ return new SachDAO();}
    @Override
    public ArrayList<Sach> getAll() {
        Connection cnt = jdbcconnect.getConnection();
        ArrayList<Sach> a  = new ArrayList<>();

        String query = "Select * from Sach";
        try {
            PreparedStatement p = cnt.prepareStatement(query);
            ResultSet r = p.executeQuery();
            while(r.next())
            {
                
                Sach t = new Sach(r.getString("id"),r.getString("name"),r.getString("type"),r.getLong("quantity"),r.getString("language"),r.getString("author"),r.getInt("release"),r.getString("summarize"));
               // System.out.println(r.getString("type"));
                a.add(t);
            }
            //System.out.println(a.isEmpty());
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public boolean add(Sach t) {
        Connection cnt = jdbcconnect.getConnection();
        String query = "INSERT INTO Sach(id, name, type, quantity, language, author, `release`, summarize) "
                + " VALUE(?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement p = cnt.prepareStatement(query);
            p.setString(1, t.getId());
            p.setString(2, t.getBookName());
            p.setString(3, t.getBookType());
            p.setLong(4, t.getBookQuantity());
            p.setString(5, t.getLanguage());
            p.setString(6, t.getBookAuthor());
            p.setInt(7, t.getYearRelease());
            p.setString(8, t.getBookSummarize());
            System.out.println(p);
            p.execute();
            cnt.close();
            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
          
        }
        return true;
    }

    @Override
    public boolean detele( String id) {
        Connection cnt  = jdbcconnect.getConnection();
        String query = "Delete from sach where id = ?";
        int rowAffected;
        try {
            PreparedStatement p = cnt.prepareStatement(query);
            p.setString(1, id);
          rowAffected = p.executeUpdate();
          
            p.execute();
            cnt.close();

            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        if(rowAffected == 0)
            return false;
        else
        return true;
    }

    @Override
    public boolean update(Sach t,String id) {
        Connection cnt = jdbcconnect.getConnection();
        String query = "Update sach "
                + "set id = ?,name = ?,type = ?,quantity = ?,language = ? ,author = ?, `release` = ?,summarize = ?"
                + "where id = ?";
        try {
            
                    
            PreparedStatement p =  cnt.prepareStatement(query);
              p.setString(1, t.getId());
            p.setString(2, t.getBookName());
            p.setString(3, t.getBookType());
            p.setLong(4, t.getBookQuantity());
            p.setString(5, t.getLanguage());
            p.setString(6, t.getBookAuthor());
            p.setInt(7, t.getYearRelease());
            p.setString(8, t.getBookSummarize());
            p.setString(9, id);
            p.execute();
            
            //id, name, type, quantity, language, author, `release`, summarize
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public void sx() {
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String search(String name) {
        Connection cnt = jdbcconnect.getConnection();
        String query = "Select * from sach where id = ? ";
        String result = "";
        try {
            PreparedStatement p = cnt.prepareStatement(query);
            p.setString(1, name);
            ResultSet r = p.executeQuery();
            while(r.next())
            {
                System.out.println("ID: "+r.getString(1)+"\tName: "+r.getString(2)+"\tType: "+r.getString(3));
                System.out.print("\n-------------------------------------------------------------\n");
                result += "ID: "+r.getString(1)+"\tName: "+r.getString(2)+"\tType: "+r.getString(3) +"\n";
            }

            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result.isBlank())
        {
            return "Ban ghi ten "+name+"Khong thay";
        }
        return result;
    }
}
