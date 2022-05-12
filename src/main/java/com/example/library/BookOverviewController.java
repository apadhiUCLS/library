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
    private Button btnCheckoutHardcover;
    @FXML
    private Button btnCheckoutPaperback;
    @FXML
    private Button btnFavorite;
    @FXML
    private Label lblHardcoverCopies;
    @FXML
    private Label lblPaperbackCopies;
    @FXML
    private Button returnButtonHardcover;
    @FXML
    private Button returnButtonPaperback;
    private Book b;

    private Person p=new Person("Person");

    @FXML
    public void goBack() throws IOException {
         LibraryApplication.switchToMainView();
    }

    @FXML
    public void checkoutHardcover() throws IOException {
        LibraryApplication.switchToCheckoutView(b.checkoutHardcover(p));
    }

    @FXML
    public void checkoutPaperback() throws IOException {
        LibraryApplication.switchToCheckoutView(b.checkoutPaperback(p));
    }

    @FXML
    public void setBtnFavorite() throws IOException {
        b.addFavorite(p);
        LibraryApplication.switchToFavoriteView(p);
    }

    @FXML
    public void returnHardcover() throws IOException {
            LibraryApplication.switchToCheckoutView(b.returnHardcover(p));
    }

    @FXML
    public void returnPaperback() throws IOException {
        LibraryApplication.switchToCheckoutView(b.returnPaperback(p));
    }

    public void setBook(Book b) {
        this.b = b;
        this.lblTitle.setText(b.getTitle());
        this.lblAuthor.setText(b.getAuthor().toString());
        this.lblBlurb.setText(b.getDescription());
        this.lblPaperbackCopies.setText(Integer.toString(b.getInvPaperback()));
        this.lblHardcoverCopies.setText(Integer.toString(b.getInvHardcover()));
    }

    @FXML
    public void initialize() {
    }
}
