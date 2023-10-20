/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.sql.ResultSet; 
/**
 *
 * @author A715-42G
 * @param <T>
 */
public interface DAOInterface<T> {
    public int insert(T t);
    
    public int update(T t);
    
    public int delete(T t);
    
    public T selectByID(T t);
    
    public ArrayList<T> selectByCond(String cond); 
    
}
