package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class RenewViewController {
    @FXML
    private Label message;

    @FXML
    private Button backToBrowse;

    private Person p;

    @FXML
    public void goBackToBrowse() throws IOException {
        LibraryApplication.switchToMainView(p);
    }

    @FXML
    public void initialize() {
    }

    @FXML
    public void setMessage(String m){
        this.message.setText(m);
    }

    public void setPerson(Person p){
        this.p = p;
    }
}
