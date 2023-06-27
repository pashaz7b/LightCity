package org.example;

import org.example.models.User;

import java.io.*;
import java.util.ArrayList;

public class MyFile {
    //C:\Users\LENOVO\OneDrive\Desktop\LightCity\files>
    private static String userPath = "C:\\Users\\LENOVO\\OneDrive\\Desktop\\LightCity\\files\\user.txt";
    public static ArrayList<User> users = new ArrayList();

    public static void writeUser() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(userPath))) {
            for (User user : users) {
                out.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUser() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(userPath))) {
            while (true) {
                User user = (User) in.readObject();
                users.add(user);
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void save(User user) {
        users.add(user);
        writeUser();
    }
}
