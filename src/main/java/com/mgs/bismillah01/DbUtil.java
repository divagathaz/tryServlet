package com.mgs.bismillah01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	private static Connection connection = null;

        public static void main(String[] args) {
        getConnection();
    }
    public static Connection getConnection() {
        
        if (connection != null){
            
            return connection;
        }
        else {
            
            try {
            	
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/kampus";
                String user = "root";
                String password = "4g4th4";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("suksemms");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("sukses");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("sukses2");
            } 
            return connection;
        }

    }
}
