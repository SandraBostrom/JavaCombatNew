package org.example.JunitTests;

import org.example.Models.AllPoke;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class AllPokeTest {
    @Test
    public void checkThatHpIsNotEmptyBeforeBattle() throws SQLException {
        AllPoke poke =  new AllPoke();
        poke.retrivefromDB();
        assertTrue(poke.getHp() != null);
    }
    @Test
    public void checkThatDefenseIsNotEmptyBeforeBattle() throws SQLException {
        AllPoke allPoke =  new AllPoke();
        allPoke.retrivefromDB();
        assertTrue(allPoke.getDefense() != null);
    }
    @Test
    public void checkThatStrengthIsNotEmptyBeforeBattle() throws SQLException {
        AllPoke allPoke =  new AllPoke();
        allPoke.retrivefromDB();
        assertTrue(allPoke.getStrength() != null);
    }

    @Test
    public void checkThatSpeedIsNotEmptyBeforeBattle() throws SQLException {
        AllPoke allPoke =  new AllPoke();
        allPoke.retrivefromDB();
        assertTrue(allPoke.getSpeed() != null);
    }

}