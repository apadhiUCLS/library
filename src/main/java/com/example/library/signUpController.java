package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class signUpController {
    @FXML
    private Button back;


    @FXML
    private TextField name;

    @FXML
    private Button signUp;

    @FXML
    private Label message;

    private Person p;
    private ArrayList<Person> people;

    @FXML
    public void goBack() throws IOException {
        LibraryApplication.switchToMainView(p, people);
    }

    public void setPerson(Person p){
        this.p= p;
    }

    public void setPeople(ArrayList<Person> people){
        this.people= people;
    }

    @FXML
    public void initialize() {
    }

    public void setSignUp() {
        String temp = name.getText();
        Boolean existing = false;
        for(int i = 0; i < people.size(); i++){
            if ((temp).equals(people[i].getPerson().getName())){
                existing = true;
            }
        }
        if (existing){
            message.setText("That Username Already exists. Choose another one.");
        } else {
            message.setText("Thank You For Signing Up! Welcome " + p);
            Person tempP = new Person(name.getText());
            people.add(tempP);
        }
public class signUpController {
    public void initialize() {

    }
}
