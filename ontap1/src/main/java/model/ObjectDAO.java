/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ObjectDAO<T>{
    public ArrayList<T> getAll();
    public boolean add(T t);
    public boolean detele(String id);
    public boolean update(T t,String id);
    public void sx();
    public String search(String name);
}
