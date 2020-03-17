package org.example.Models;

import org.example.DB.MySqlConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Fighters {

    private static ResultSet rs;
    private static Connection conn = MySqlConnection.getConnection();
    private static Statement stmt;
    public static List<String> matchmaking = new ArrayList<String>();
    public static List<String> finalesFighter = new ArrayList<>();
    public static String fighter1, fighter2;

    static {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean retrieveFromDb() {
        try {
            Random rand = new Random();
            rs = stmt.executeQuery("SELECT Pokemon FROM pokemons");
            while (rs.next()) {
                matchmaking.add(rs.getString(1));
            }

            if (matchmaking.size() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (matchmaking.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void makeBattle() {
        java.util.Collections.shuffle(matchmaking);
        int[] chosen1 = new int[1];
        for (int i = 0; i < chosen1.length && matchmaking.size() > 0; i++) {
            fighter1 = matchmaking.get(chosen1[i]);
            matchmaking.remove(fighter1);

        }
        int[] chosen2 = new int[1];
        for (int i = 0; i < chosen2.length && matchmaking.size() > 0; i++) {
            fighter2 = matchmaking.get(chosen2[i]);
            matchmaking.remove(fighter2);

        }
        checkPlayers(fighter1,fighter2);
    }

    public static void makefinale() throws SQLException {
        java.util.Collections.shuffle(finalesFighter);
        int[] chosen1 = new int[1];
        for (int i = 0; i < chosen1.length && finalesFighter.size() > 0; i++) {
            fighter1 = finalesFighter.get(chosen1[i]);
            finalesFighter.remove(fighter1);
        }
        int[] chosen2 = new int[1];
        for (int i = 0; i < chosen2.length && finalesFighter.size() > 0; i++) {
            fighter2 = finalesFighter.get(chosen2[i]);
            finalesFighter.remove(fighter2);
        } }

    public static boolean checkPlayers(String x, String y) {
        if (x != y) {
            return true;
        } else {
            return false;
        }
    }
}

