package org.example;

import org.example.View.View;

import java.sql.SQLException;
import java.util.Scanner;

public class main {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to the game.\n Press 1 to see all the fighters availabe \n press 2 to start the first combat");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                getAllPokemons();
                System.out.println("\nNow we start the game\n");
                startTheGame();
                break;
            case 2:
                startTheGame();
                break;
        }
    }

    static void getAllPokemons() throws SQLException {
        View.allpoke();
    }

    static void startTheGame () throws SQLException {
        View.battle1();
        System.out.println("That was a good fight, are you ready for fight number 2? press ENTER");
        String readString = scan.nextLine();
        System.out.println(readString);
        if (scan.hasNextLine()) {
            View.battle2();
        }
        System.out.println("Woooow, that was a great fight, now we move on to round 3. \nPRESS ENTER");
        readString = scan.nextLine();
        System.out.println(readString);
        if (scan.hasNextLine()) {
            View.battle3();
        }
        System.out.println("THE LAST BATTLE before the finales begin, Kick some asses now!!. \nPRESS ENTER");
        readString = scan.nextLine();
        System.out.println(readString);
        if (scan.hasNextLine()) {
            View.battle4();
        }
        System.out.println("And so it begins, THE SEMIFINALES!. \nPRESS ENTER");
        readString = scan.nextLine();
        System.out.println(readString);
        if (scan.hasNextLine()) {
            View.semifinale();
        }
        System.out.println("Now it's close, just 1 battle til the finale!. \nPRESS ENTER");
        readString = scan.nextLine();
        System.out.println(readString);
        if (scan.hasNextLine()) {
            View.semifinale();
        }
        System.out.println("The last battle, now it's time to see which one of you two who are the best pokemon!. \nPRESS ENTER");
        readString = scan.nextLine();
        System.out.println(readString);
        if (scan.hasNextLine()) {
            View.finale();
        }
    }
        }

