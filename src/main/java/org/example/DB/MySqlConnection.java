package org.example.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static Connection conn;
    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemons", "student", "Kirre940217");
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return conn;
    }


}
