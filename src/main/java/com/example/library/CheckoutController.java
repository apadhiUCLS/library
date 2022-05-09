package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class CheckoutController {

    @FXML
    private Button listButton;

    @FXML
    private Label message;

    @FXML
    private Label action;

    @FXML
    private Button backToBrowse;

    @FXML
    public void goBackToBrowse() throws IOException {
        LibraryApplication.switchToMainView();
    }

    @FXML
    public void initialize() {
    }

    @FXML
    public void goBack() throws IOException {
        LibraryApplication.switchToMainView();
    }

    public void setMessage(String m){
        this.message.setText(m);
    }

    public void setLabel(String l){
        action.setText(l);

    }
}
