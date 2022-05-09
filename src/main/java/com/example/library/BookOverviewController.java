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
    private Button btnCheckout;
    @FXML
    private Label lblCopies;
    @FXML
    private Button returnButton;
    private Book b;

    private Person p=new Person("Person");

    @FXML
    public void goBack() throws IOException {
         LibraryApplication.switchToMainView();
    }

    @FXML
    public void checkout() throws IOException {
        LibraryApplication.switchToCheckoutView(b.checkout(p));
    }

    @FXML
    public void setReturnButton() throws IOException {
            LibraryApplication.switchToCheckoutView(b.returnBook(p));
    }

    public void setBook(Book b) {
        this.b = b;
        this.lblTitle.setText(b.getTitle());
        this.lblAuthor.setText(b.getAuthor().toString());
        this.lblBlurb.setText(b.getDescription());
        this.lblCopies.setText(Integer.toString(b.getInventory()));
    }

    @FXML
    public void initialize() {
    }
}
