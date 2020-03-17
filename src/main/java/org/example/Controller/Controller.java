package org.example.Controller;

import org.example.DB.MySqlConnection;
import org.example.DB.MySqlUpdateResult;
import org.example.Models.AllPoke;
import org.example.Models.Battle;
import org.example.Models.Fighters;
import org.example.View.View;

import java.sql.*;
import java.util.Random;

public class Controller {

    private Battle battle;
    private AllPoke allPoke;
    private View view;

    private static Connection conn = MySqlConnection.getConnection();
    private static Statement stmt;
    static Random rand = new Random();
    static {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static int hp, strength,speed,defense,hp2,strength2,defense2,speed2;
    private static String fighter2, fighter1;




    public Controller(AllPoke allPoke, View view){
        this.allPoke = allPoke;
        this.view = view;
    }

    public void updateView() throws SQLException {
        view.allPokeText(allPoke.getPokemon());
        allPoke.getItAll();
    }

    public Controller(Battle battle, View view) {
        this.battle = battle;
        this.view = view;
    }

    public static String getFighter1() {
        setFighter1();
        return fighter1;
    }

    public static void setFighter1() {
        fighter1 = Fighters.fighter1;
    }

    public static String getFighter2() {
        setFighter2();
        return fighter2;
    }

    public static void setFighter2() {
        fighter2 = Fighters.fighter2;
    }

    public static void makeBattle() throws SQLException {
        Fighters.makeBattle();
    }
    public static void makeFinale() throws SQLException {
        Fighters.makefinale();
    }
    public static void retrievefromdb() throws SQLException {
        Fighters.retrieveFromDb();
    }
    public static void fight() throws SQLException {
        Battle.fight();
    }
    public static void finalFights() throws SQLException {
        Battle.finalFights();
    }

    public static void setResult() throws SQLException {
        MySqlUpdateResult.setResult();
    }

    public static int getHp() throws SQLException {
        setHp();
        return hp;
    }

    public static void setHp() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("select hp from pokemons where Pokemon =?");
        statement.setString(1, Fighters.fighter1);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            System.out.println("\n" + Fighters.fighter1);
            hp = rs.getInt(1);
        }
    }
    public static void setStrength() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("select strength from pokemons where Pokemon =?");
        statement.setString(1, Fighters.fighter1);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            strength = rs.getInt(1);
        }    }

    public static int getStrength() throws SQLException {
        setStrength();
        return strength;
    }


    public static int getSpeed() throws SQLException {
        setSpeed();
        return speed;
    }

    public static void setSpeed() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("select speed from pokemons where Pokemon =?");
        statement.setString(1, Fighters.fighter1);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            speed = rs.getInt(1);
        }    }

    public static int getDefense() throws SQLException {
        setDefense();
        return defense;
    }

    public static void setDefense() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("select defense from pokemons where Pokemon =?");
        statement.setString(1, Fighters.fighter1);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            defense = rs.getInt(1);
        }    }


    public static void getAllStats() throws SQLException {
        getHp();
        getSpeed();
        getStrength();
        getDefense();
    }

    public static int getHp2() throws SQLException {
        setHp2();
        return hp2;
    }

    public static void setHp2() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("select hp from pokemons where Pokemon =?");
        statement.setString(1, Fighters.fighter2);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            System.out.println("\n" + Fighters.fighter2);
            hp2 = rs.getInt(1);
        }
    }
    public static void setStrength2() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("select strength from pokemons where Pokemon =?");
        statement.setString(1, Fighters.fighter2);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            strength2 = rs.getInt(1);
        }    }

    public static int getStrength2() throws SQLException {
        setStrength2();
        return strength2;
    }


    public static int getSpeed2() throws SQLException {
        setSpeed2();
        return speed2;
    }

    public static void setSpeed2() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("select speed from pokemons where Pokemon =?");
        statement.setString(1, Fighters.fighter2);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            speed2 = rs.getInt(1);
        }    }

    public static int getDefense2() throws SQLException {
        setDefense2();
        return defense2;
    }

    public static void setDefense2() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("select defense from pokemons where Pokemon =?");
        statement.setString(1, Fighters.fighter2);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            defense2 = rs.getInt(1);
        }    }

    public static void getAllStats2() throws SQLException {
        getHp2();
        getSpeed2();
        getStrength2();
        getDefense2();
    }
}

