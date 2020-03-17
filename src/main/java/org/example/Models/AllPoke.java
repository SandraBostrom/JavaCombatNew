package org.example.Models;

import org.example.DB.MySqlConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


// This class get all the pokemons available from the MySql-database and print them out in the console.

public class AllPoke {
        private List<String> hpList = new ArrayList<>();
        private List<String> strength = new ArrayList<>();
        public List<String> pokemons = new ArrayList<>();
        private List<String> abilities = new ArrayList<>();
        private List<String> defense = new ArrayList<>();
        private List<String> speed = new ArrayList<>();

        private static ResultSet rs;
        private static Connection conn = MySqlConnection.getConnection();
        private static Statement stmt;

        private AllPoke allPoke;

        static {
            try {
                stmt = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void retrivefromDB() throws SQLException {

            rs = stmt.executeQuery("SELECT * FROM pokemons");
            while (rs.next()) {
                setPokemon((rs.getString("Pokemon")));
                setAbilities((rs.getString("Abilities")));
                setHp((rs.getString("Hp")));
                setDefense((rs.getString("Defense")));
                setSpeed((rs.getString("Speed")));
                setStrength((rs.getString("Speed")));

            }
        }

        public List<String> getHp() {
            return hpList;
        }

        public void setHp(String hp) {
            hpList.add(hp);
        }

        public void setStrength(String strength1) {
            strength.add(strength1);
        }

        public List<String> getStrength() {
            return strength;
        }

        public List<String> getDefense() {
            return defense;
        }

        public void setDefense(String defense2) {
            defense.add(defense2);
        }

        public List<String> getSpeed() {
            return speed;
        }

        public void setSpeed(String speed2) {
            speed.add(speed2);
        }

        public List<String> getPokemon() {
            return pokemons;
        }

        public void setPokemon(String pokemon) {
            pokemons.add(pokemon);
        }

        public List<String> getAbilities() {
            return abilities;
        }

        public void setAbilities(String ability) {
            abilities.add(ability);
        }

        public void getItAll() {
            for (int i = 0; i < pokemons.size(); i++)
                System.out.println("Pokemon: " + pokemons.get(i) + "\nAbility: " + abilities.get(i) + "\nHP: " + hpList.get(i)
                        + "\nSpeed: " + speed.get(i) + "\nStrength: " + strength.get(i) + "\nDefense: " + defense.get(i) + "\n");

        }
    }


