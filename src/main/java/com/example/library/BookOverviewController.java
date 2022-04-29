package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

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
    public void goBack() {
         LibraryApplication.switchToBrowse();
    }

    public void setBook(Book b) {
        this.b = b;
    }

    @FXML
    public void initialize() {
        this.lblTitle.setText(b.getTitle());
        this.lblAuthor.setText(b.getAuthor());
        this.lblBlurb.setText(b.getDescription());
        this.lblCopies.setText(b.getCopies());
    }
}
