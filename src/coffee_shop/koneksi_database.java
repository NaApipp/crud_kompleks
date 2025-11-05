/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class koneksi_database {
    private static Connection koneksi;
    public static Connection getKoneksi;
    public static Statement stm;
    public static ResultSet res;
    
    public static Connection getKoneksi() {
        try {
            String url = "jdbc:mysql://localhost:3306/db_coffee_shop";
            String user="root";
            String pass="";
            
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(url, user, pass);
            
        } catch (Exception e) {
            System.err.println("gagal" +e.getMessage());
        }
        return koneksi;
    }
}
