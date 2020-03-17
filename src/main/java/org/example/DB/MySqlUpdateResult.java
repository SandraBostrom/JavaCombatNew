package org.example.DB;

import org.example.Models.Battle;
import org.example.Models.Fighters;

import java.sql.*;

public class MySqlUpdateResult {
    private static ResultSet rs;
    private static Connection conn = MySqlConnection.getConnection();
    private static Statement stmt;

    static {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static MySqlUpdateResult result;

    private static void SingletonResult() throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "update pokemons set hp = ?,strength = ?,speed = ?, defense =? where Pokemon =?");
        statement.setInt(1, Battle.hp);
        statement.setInt(2, Battle.strength);
        statement.setInt(3, Battle.speed);
        statement.setInt(4, Battle.defense);
        statement.setString(5, Fighters.fighter1);
        int rs = statement.executeUpdate();

        statement = conn.prepareStatement(
                "update pokemons set hp = ?,strength = ?,speed = ?, defense =? where Pokemon =?");
        statement.setInt(1, Battle.hp2);
        statement.setInt(2, Battle.strength2);
        statement.setInt(3, Battle.speed2);
        statement.setInt(4, Battle.defense2);
        statement.setString(5, Fighters.fighter2);
        rs = statement.executeUpdate();

    }

    public static MySqlUpdateResult setResult() throws SQLException {
        if (result == null) {
            SingletonResult();
        }
        return result;
    }
}