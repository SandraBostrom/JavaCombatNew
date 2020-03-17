package org.example.JustAMockTest;

import org.example.DB.MySqlConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// This class doesn't do anything yet. Right now it's just a class connected to an interface so that I can test using mock-test.
// Later this class will choose some "special" pokemons from the game, that might get some extra powers/abilites..

public class SpecialPokemonsImpl {
    private static ResultSet rs;
    private static Connection conn = MySqlConnection.getConnection();
    private static Statement stmt;
    public static List<String> pokemons = new ArrayList<>();
    SpecialPokemons specialPokemons;

    public SpecialPokemonsImpl(SpecialPokemons specialPokemons) {
        this.specialPokemons = specialPokemons;
    }

    public List<String>retrieveSpeicalPokemons(String pokemon) {
        List<String> filteredPokemons = new ArrayList<String>();
        List<String> pokemons = specialPokemons.retrievePokemons(pokemon);
        for (String poke : pokemons) {
            if (poke.contains("Raichu")) {
                filteredPokemons.add(poke);
            }
        }
        return filteredPokemons;
    }
}
