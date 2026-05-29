package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/supply_chain_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Hansika@123";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            System.out.println("DB Connection Error: " + e);
            return null;
        
        }
    }
}