package com.example.library;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javafx.fxml.FXML;

public class ChooseUserController {
    private ArrayList<Person> people;

    public ArrayList<Person> getUserList() {
        return people;
    }

    public void setUserList(ArrayList<Person> users) {
        people = users;

        String home = System.getProperty("user.home");
        Path folderPath = Paths.get(home + "/.libraryUsers");
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(folderPath + "/users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(people);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in users.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    @FXML
    public void initialize() {
        String home = System.getProperty("user.home");
        Path folderPath = Paths.get(home + "/.libraryUsers");
        if (!Files.exists(folderPath)) {
            try {
                Files.createDirectory(folderPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            FileInputStream fileIn = new FileInputStream(folderPath + "/users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            people = (ArrayList<Person>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
            return;
        }
    }
}
