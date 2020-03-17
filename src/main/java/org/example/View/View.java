package org.example.View;

import org.example.Controller.Controller;
import org.example.Models.AllPoke;
import org.example.Models.Fighters;

import java.sql.SQLException;
import java.util.List;

public class View {

    public void allPokeText(List<String> pokemon) throws SQLException {

        System.out.println("Pokemons: " + pokemon + "\n");
    }

    public static void allpoke() throws SQLException {
        AllPoke poke = new AllPoke();
        poke.retrivefromDB();

        View view = new View();

        Controller controller = new Controller(poke, view);
        controller.updateView();
    }

    public static void battle1() throws SQLException {
        System.out.println("---------------");
        System.out.println("    Match 1");
        System.out.println("---------------");
        Controller.retrievefromdb();
        Controller.makeBattle();
        battleText();
        Controller.fight();
        Controller.setResult();
    }

    public static void battle2() throws SQLException {
        System.out.println("---------------");
        System.out.println("    Match 2");
        System.out.println("---------------");
        Controller.makeBattle();
        battleText();
        Controller.fight();
        Controller.setResult();
    }

    public static void battle3() throws SQLException {
        System.out.println("---------------");
        System.out.println("    Match 3");
        System.out.println("---------------");
        Controller.makeBattle();
        battleText();
        Controller.fight();
        Controller.setResult();
    }

    public static void battle4() throws SQLException {
        System.out.println("---------------");
        System.out.println("    Match 4");
        System.out.println("---------------");
        Controller.makeBattle();
        battleText();
        Controller.fight();
        Controller.setResult();
    }
    public static void semifinale() throws SQLException {
        System.out.println("---------------");
        System.out.println("    SEMIFINALE");
        System.out.println("---------------");
        Controller.makeFinale();
        battleText();
        Controller.fight();
        Controller.setResult();
    }

    public static void finale() throws SQLException {
        System.out.println("---------------");
        System.out.println("   THE BIG FINALE");
        System.out.println("---------------");
        Controller.makeFinale();
        battleText();
        Controller.finalFights();
        Controller.setResult();
    }


    public static void battleText() throws SQLException {
        System.out.println("You are: " + Controller.getFighter1());
        System.out.println("You meet: " + Controller.getFighter2());
        System.out.print("\nFighters left: " + Fighters.matchmaking);
        System.out.println("\nFighters ready for the finales: " + Fighters.finalesFighter + "\n");
    }
}
