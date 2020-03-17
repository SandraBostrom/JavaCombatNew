package org.example.Models;

import org.example.Controller.Controller;
import org.example.DB.MySqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;


//In this class the battle between two pokemons is created.

public class Battle {
    public static int hp, hp2,strength,strength2,speed,speed2,defense,defense2,player1Hit,player2Hit,player1defense,player2defense
            ,player2Choice;
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

    public static void showDetails() throws SQLException {
        System.out.println("HP:" + (hp = Controller.getHp()) + "\nStrength: " +
                (strength = Controller.getStrength()) + "\nSpeed: " + (speed = Controller.getSpeed()) +
                "\nDefense: " + (defense = Controller.getDefense()));

        System.out.println("HP:" + (hp2 = Controller.getHp2()) + "\nStrength: " +
                (strength2 = Controller.getStrength2()) + "\nSpeed: " + (speed2 = Controller.getSpeed2()) +
                "\nDefense: " + (defense2 = Controller.getDefense2()) + "\n");

    }
    public static void fighter1() throws SQLException {
        player1Hit = rand.nextInt(strength * 2);
        player2defense = rand.nextInt(defense2 / 2);

        player2Choice = 0;
        player2Choice = rand.nextInt(2);
        if (player2Choice == 0) {
            System.out.println("\nYou attacked with a power of " + player1Hit + " but " + Fighters.fighter2 + " defended\n ");
            hp2 -= (player1Hit - player2defense);
            speed2 -= 10;
            System.out.println(Fighters.fighter2 + " HP: " + hp2);
        } else if (player2Choice == 1) {
            System.out.println("You attacked with a power of " + player1Hit + "\n");
            hp2 -= player1Hit;
            System.out.println(Fighters.fighter2 + " HP: " + hp2);

        }
    }

    public static void fighter2() throws SQLException {
         player2Hit = rand.nextInt(strength2 / 2);
         player1defense = rand.nextInt(defense / 2);

        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + Fighters.fighter2 + " made an attack with " + player2Hit + " strength\nDefend yourself! Press enter");
        scan.hasNextLine();
        System.out.println("You defended yorself with a power of " + player1defense);
        speed -= 5;
        hp -= player2Hit;
        System.out.println("Your HP: " + hp + "\n");
    }


    public static void fight() throws SQLException {
        showDetails();
        Scanner scan = new Scanner(System.in);
        do {
            fighter1();
            fighter2();
        }
        while (hp > 0 && hp2 > 0);

        if (hp <= 10) {
            hp = 70;

            strength -= strength / 2;
            if (strength <= 0) {
                strength = 20;
            }
            speed -= speed / 2;
            if (speed <= 10) {
                speed = 20;
            }
            defense -= defense / 2;
            if (defense <= 10) {
                defense = 20;
            }
            System.out.println("You loose the game \nYour new stats \nHP: " + hp + "\nSpeed:" + speed + "\nDefense: " + defense
                    + "\nStrength: " + strength);
            hp2 = hp2 * 2;
            if (hp2 <= 10)
                hp2 = 50;

            strength2 = strength2 * 2;
            if (strength2 <= 10)
                strength2 = 20;

            speed2 = strength2 * 2;
            if (speed2 <= 10)
                speed2 = 20;

            defense2 = defense2 * 2;
            if (defense2 <= 10)
                defense2 = 20;
            System.out.println(Fighters.fighter2 + " are the winner");
            Fighters.finalesFighter.add(Fighters.fighter2);
        }
        if (hp2 <= 0) {
            hp2 = 70;
            strength2 -= strength2 / 2;
            if (strength2 <= 10) {
                strength2 = 20;
            }
            speed2 -= speed2 / 2;
            if (speed2 <= 10) {
                speed2 = 20;
            }
            defense2 -= defense2 / 2;
            if (defense2 <= 10) {
                defense2 = 20;
            }
            hp = hp;
            if (hp <= 10)
                hp = 50;

            strength = strength * 2;
            if (strength <= 10)
                strength = 50;

            speed = speed * 2;
            if (speed <= 10)
                speed = 50;

            defense = defense * 2;
            if (defense <= 10)
                defense = 50;

            System.out.println("You won.\nYour new stats: \nHP: " + hp + "\nSpeed: " + speed + "\nDefense: " + defense + "\nStrength: " + strength);
            Fighters.finalesFighter.add(Fighters.fighter1);
        }
    }

    public static void finalFights() throws SQLException {
        showDetails();
        Scanner scan = new Scanner(System.in);
        do {
            fighter1();
            fighter2();
        }
        while (hp > 0 && hp2 > 0);

        if (hp <= 0) {
            hp = 70;

            strength -= strength / 2;
            if (strength <= 0) {
                strength = 20;
            }
            speed -= speed / 2;
            if (speed <= 0) {
                speed = 20;
            }
            defense -= defense / 2;
            if (defense <= 0) {
                defense = 20;
            }
            System.out.println("You loose the game \nYour new stats \nHP: " + hp + "\nSpeed:" + speed + "\nDefense: " + defense
                    + "\nStrength: " + strength);
            hp2 = hp2 * 2;
            if (hp2 == 0)
                hp2 = 50;

            strength2 = strength2 * 2;
            if (strength2 == 0)
                strength2 = 10;

            speed2 = strength2 * 2;
            if (speed2 == 0)
                speed2 = 10;

            defense2 = defense2 * 2;
            if (defense2 == 0)
                defense2 = 10;
            System.out.println(Fighters.fighter2 + " are the winner");
        }
        if (hp2 <= 0) {
            hp2 = 70;
            strength2 -= strength2 / 2;
            if (strength2 <= 0) {
                strength2 = 20;
            }
            speed2 -= speed2 / 2;
            if (speed2 <= 0) {
                speed2 = 20;
            }
            defense2 -= defense2 / 2;
            if (defense2 <= 0) {
                defense2 = 20;
            }
            hp = hp;
            if (hp == 0)
                hp = 50;

            strength = strength * 2;
            if (strength == 0)
                strength = 50;

            speed = speed * 2;
            if (speed == 0)
                speed = 50;

            defense = defense * 2;
            if (defense == 0)
                defense = 50;

            System.out.println("You won.\nYour new stats: \nHP: " + hp + "\nSpeed: " + speed + "\nDefense: " + defense + "\nStrength: " + strength);
        }
    }
}