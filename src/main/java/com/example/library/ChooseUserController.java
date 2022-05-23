package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

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
    private ArrayList<Person> people;



    @FXML
    public void initialize() {
    }

    public void setPerson(Person p){
        this.p= p;
    }

    public void setLogin() {
        String tempU = username.getText();
        Boolean loggedIn = false;
        for(int i = 0; i < people.size(); i++){
            if ((tempU).equals(people[i].getPerson().getName())){
                loggedIn = true;
                p = people[i].getPerson();
            }
        }
        if (loggedIn){
            message.setText("Login Successful. Welcome " + p);
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

}
