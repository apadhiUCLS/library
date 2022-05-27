package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javafx.fxml.FXML;

public class ChooseUserController {
    @FXML
    private Button back;

    @FXML
    private Button login;

    @FXML
    private Button signUp;

    @FXML
    private TextField username;

    @FXML
    private Label message;

    private Person p;

    private static Path path;

    private static ArrayList<Person> people = new ArrayList<Person>();


// this controller and the sign up controller shouldn't need a set person and shouldn't need a person to get started
    //but I am pretty sure that is not what is messing it up.
    //I couldn't find a place here or when switching to main view that should change the person, but it might be useful
    //have a static person we use everywhere (if we can't actually figure out what the problem is).
    public void setPerson(Person p) {
        this.p = p;
    }

    public void setLogin() {
        String tempU = username.getText();
        Boolean loggedIn = false;
        for (int i = 0; i < people.size(); i++) {
            if ((tempU).equals(people.get(i).getName())) {
                loggedIn = true;
                p = people.get(i);
                System.out.println(p);
                System.out.println(people);
            }
        }
        if (loggedIn) {
            message.setText("Login Successful. Welcome " + p.getName());
        } else {
            message.setText("Login is not successful, try again.");
        }
    }

    public void setSignUp() throws IOException {
        LibraryApplication.switchToSignUpView(p);
    }

    @FXML
    public void goBack() throws IOException {
        LibraryApplication.switchToMainView(p);
    }

    public static ArrayList<Person> getUserList() {
        return people;
    }

    //tell Elizabeth to change how she is calling it since it is now static (should just have
    //to make sure she is calling on the class and delete the getting controller stuff)
    public static void setUserList(ArrayList<Person> users) throws IOException {
        people = users;

        /*String home = System.getProperty("user.home");
        Path folderPath = Paths.get(home + "/.libraryUsers");*/
        path = FileSystems.getDefault().getPath(System.getProperty("user.home"), ".libraryUsers");
        if (!Files.exists(path)){
            Path p=Files.createDirectory(path);
        }

        try {
            FileInputStream fileIn = new FileInputStream(path+"/patientdb.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            people = (ArrayList<Person>) in.readObject();
            in.close();
            fileIn.close();
            /*FileOutputStream fileOut = new FileOutputStream(folderPath + "/users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(people);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in users.ser");*/

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
            if (people==null){
                people=new ArrayList<Person>();
            }
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
