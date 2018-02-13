package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Koneksi {
    
    String uname;
    String passwd;
    private static Connection mysqlkonek;
    //public static Statement stm;
    public Connection koneksiDB() throws SQLException {
        if(mysqlkonek==null){
            try {
                String DB="jdbc:mysql://localhost/laundry_dia"; //
                String user="adminlaundry"; // user database
                String pass="@adminlaundry1"; // password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"KONEKSI GAGAL");
            }
        }
        return mysqlkonek;
    }
}