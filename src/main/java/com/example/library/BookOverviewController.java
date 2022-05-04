package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.io.IOException;

public class BookOverviewController {
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblAuthor;
    @FXML
    private Label lblBlurb;
    @FXML
    private Button btnBack;
    @FXML
    private Label lblCopies;
    private Book b;

    @FXML
    public void goBack() throws IOException {
         LibraryApplication.switchToMainView();
    }

    public void setBook(Book b) {
        this.b = b;
        this.lblTitle.setText(b.getTitle());
        this.lblAuthor.setText(b.getAuthor().toString());
        this.lblBlurb.setText(b.getDescription());
    }

    @FXML
    public void initialize() {
    }
}
