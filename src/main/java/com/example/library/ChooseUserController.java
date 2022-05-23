package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChooseUserController {
    @FXML
    private Button back;

    @FXML
    private Button login;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    private Person p;
    private String m;


    @FXML
    public void initialize() {
    }

    public void setLogin() {
        String tempU = username.getText();
        String tempP = password.getText();
        Boolean loggedIn = false;
        for(int i = 0; i < people.length; i++){
            if ((tempU + tempP).equals(people[i].getC())){
                p = people[i].getPerson();
                loggedIn = true;
            }
        }
        if (loggedIn){
            m = "Login Successful. Welcome " + p;
        } else {
            m = "Login is not successful, try again.";
        }
    }

    @FXML
    public void goBack() throws IOException {
        LibraryApplication.switchToMainView(p);
    }

}
