/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;

/**
 *
 * @author Asus
 */
public class koneksi {
    public Connection koneksi;
    public Statement stm;
    public Connection connect() {
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException ex) {
            System.out.println("Koneksi Gagal "+ex);
        }
        String url = "jdbc:mysql://localhost/inventory";
        try {
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil Koneksi Database");
        } catch (SQLException ex) {
            System.out.println("Gagal Koneksi Database "+ex);
        }
        return koneksi;
    }

    public Connection getKoneksi() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}