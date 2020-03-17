package org.example.JunitTests;
import org.example.Controller.Controller;
import org.example.Models.Fighters;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


public class FightersTest {

    @Test
    public void checkDifferentPlayer() throws SQLException {
        Fighters fighters = new Fighters();
        Controller.retrievefromdb();
        Controller.makeBattle();
        boolean result = fighters.checkPlayers(Fighters.fighter1, Fighters.fighter2);
        assertTrue(result);
    }

    @Test
    public void checkNotSamePlayer() throws SQLException {
        Fighters fighters = new Fighters();
        Controller.retrievefromdb();
        Controller.makeBattle();
        boolean result = fighters.checkPlayers(Fighters.fighter1, Fighters.fighter2);
        assertTrue("Same fighters not allowed",result);
    }
    @Test
    public void checkNotNullFighters() throws SQLException {
        Fighters fighters = new Fighters();
        Controller.retrievefromdb();
        ArrayList<String> fighter = (ArrayList<String>) fighters.matchmaking;
        assertNotNull("Array is empty",fighter);
    }

}