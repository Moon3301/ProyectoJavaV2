/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentaBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public class BaseDatos {
    
    private static Connection con=null;
    
    private BaseDatos() {
        String user = "libreria";
        String passwd="1234";
        String url="jdbc:oracle:thin:@localhost:1521:XE";
     
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(url, user, passwd);
            
        } catch (ClassNotFoundException | SQLException error){
            System.out.println(error.getMessage());
        }
        
    }
    
    public static Connection getConnection(){
        if (con==null)
            new BaseDatos();
        return con;
    }
    
    
    
    
}
