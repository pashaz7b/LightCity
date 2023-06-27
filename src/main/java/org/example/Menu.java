package org.example;

import org.example.models.User;

import java.util.Scanner;

public class Menu {
    private static Game game = new Game();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        mainMenu();
        String next;
        while (true) {
            next = scanner.nextLine();
            switch (next) {
                case "1":
                    try {
                        game.continueGame(loginMenu());
                    }catch (NullPointerException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        game.startGame(SignUpMenu());
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    joinServer();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    public static void mainMenu() {
        System.out.println("1- Continue");
        System.out.println("2- Start New Game");
        System.out.println("3- Join Server");
        System.out.println("4- Exit");
    }

    public static User SignUpMenu() throws IllegalArgumentException{
        System.out.print("Enter username : ");
        String username = scanner.nextLine();
        System.out.print("Enter password : ");
        String password = scanner.nextLine();

        for (User user : MyFile.users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)){
                throw new IllegalArgumentException("This user signed up before!");
            }
        }
        User user = new User(username, password);
        MyFile.save(user);
        return user;
    }

    public static User loginMenu() throws NullPointerException{
//       get user info : username, password
        System.out.print("Enter your username : ");
        String username = scanner.nextLine();
        System.out.print("Enter your password : ");
        String password = scanner.nextLine();

        for (User user : MyFile.users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)){
                return user;
            }
        }
        throw new NullPointerException("There are no user with this information!");
    }

    private static void joinServer() {
        System.out.print("Enter Server Ip Address :");
        String ip = scanner.next();
        System.out.print("Enter Server Port :");
        int port = scanner.nextInt();
        game.joinServer(ip, port);
    }

    public static void main(String[] args) {
        MyFile.readUser();
        showMenu();
    }
}
