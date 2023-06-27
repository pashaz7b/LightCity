package org.example.models;

import org.example.defualtSystem.Bank;
import org.example.defualtSystem.Life;
import org.example.defualtSystem.Municipality;
import org.example.defualtSystem.StockMarket;
import org.example.interfaces.CityInterface;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class City implements CityInterface {
    private final ArrayList<Character> characters;
    private final Bank bankSystem;
    private final Municipality municipality;

    private final StockMarket stockMarket;

    private Character root;

    public City() {
        characters = new ArrayList<>();
        municipality = new Municipality();
//        Get Bank Property from municipality
        bankSystem = new Bank(new Property(new float[]{12, 32}, new float[]{42, 32}, root), root);
        stockMarket = new StockMarket();
        stockMarket.startMarketSimulation();
    }

    @Override
    public void joinCharacter(User userinfo) {
        BankAccount newAccount = bankSystem.newAccount(userinfo.getUsername(), userinfo.getPassword());
        Character character = new Character(userinfo, newAccount, new Life(), null, null, null);
        characters.add(character);
        beginGame(character);
    }

    @Override
    public void getCityDetail() {
        String players = Arrays.toString(characters.toArray());
    }


    /**
     * Begin Game function generate a new thread for each character ,<b > DO NOT CHANGE THIS FUNCTION STRUCTURE</b> ,
     */
    private void beginGame(Character character) {
        Thread thread = new Thread(() -> {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("1.Go to place");
                System.out.println("2.Process location");
                System.out.println("3.Dashboard");
                System.out.println("4.Life detail");
                System.out.println("5.Exit");
                while (true) {
                    switch (scanner.nextLine()) {
                        case "1": GoTo();break;
                        case "2": Process_location();break;
                        case "3":Dashboard();break;
                        case "4":Life();break;
                        case "5": {
                            System.out.println("Are you sure?");
                            System.out.println("Enter yes/y ");
                            if (scanner.nextLine().equals("yes") || scanner.nextLine().equals("y")) {
                                exit();
                            } else {
                                beginGame(character);
                            }
                        }
                        default:
                            System.out.println("Invalid input!");
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }

    private void GoTo() {
        System.out.print("Enter location or id or industry title : ");
        Scanner placeScanner = new Scanner(System.in);
        String place = placeScanner.nextLine();
    }

    private void Process_location() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Showing where is character");
        System.out.println("2.Showing option according to industry");
        switch (scanner.next()) {
            case "1":Character_Location();break;
            case "2":Ownership_Detail();break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void Character_Location() {
        System.out.println("Do something");
    }

    private void Ownership_Detail() {
        System.out.println("Do something");
    }

    private void Dashboard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.My job");
        System.out.println("2.Properties");
        System.out.println("3.Economy");
        switch (scanner.nextLine()) {
            case "1":My_Job();break;
            case "2":Properties();break;
            case "3":Economy();break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void My_Job() {
        System.out.println("Do something");
    }

    private void Properties() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Show properties");
        System.out.println("2.Sell");
        System.out.println("3.Management");
        System.out.println("4.Found industry");
        switch (scanner.nextLine()) {
            case "1":show_Properties();break;
            case "2":sell();break;
            case "3":management1();break;
            case "4":found_Industry();break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void show_Properties() {
        System.out.println("do something");
    }

    private void sell() {
        System.out.println("do something");
    }

    private void management1() {
        System.out.println("do something");
    }

    private void found_Industry() {
        System.out.println("do something");
    }

    private void Economy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Show incomes");
        System.out.println("2.Show job detail");
        switch (scanner.next()) {
            case "1":show_Incomes();break;
            case "2":show_Job_Detail();break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void show_Incomes() {
        System.out.println("do something");
    }

    private void show_Job_Detail() {
        System.out.println("do something");
    }

    private void Life() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Life detail");
        System.out.println("2.Sleep option");
        System.out.println("3.Eat option");
        switch (scanner.next()) {
            case "1":life_Detail();break;
            case "2":sleep();break;
            case "3":eat();break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void life_Detail() {
        System.out.println("do something");
    }

    private void sleep() {
        System.out.println("do something");
    }

    private void eat() {
        System.out.println("do something");
    }

    private void exit() {
        System.exit(0);
    }
}
