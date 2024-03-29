package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

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
    private Button btnRemoveFavorite;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnWantToRead;
    @FXML
    private Button btnRemoveFromWantToRead;
    @FXML
    private Label lblHardcoverCopies;
    @FXML
    private Label lblPaperbackCopies;
    @FXML
    private Button returnButtonHardcover;
    @FXML
    private Button returnButtonPaperback;
    @FXML
    private Label ratings;
    @FXML
    private Label publisher;
    @FXML
    private Label year;
    @FXML
    private Label citation;
    @FXML
    private Button btnReview;
    @FXML
    private Button btnRate;
    @FXML
    private Button btnDidNotFinish;
    @FXML
    private Button btnFinish;
    @FXML
    private Button authorView;
    @FXML
    private Button btnRenewHardcover;
    @FXML
    private Button btnRenewPaperback;

    @FXML
    private Label callNum;
    private Book b;

    private Person p;

    @FXML
    public void goBack() throws IOException {
         LibraryApplication.switchToMainView(p);
    }

    @FXML
    public void setBtnRemove() throws IOException {
        LibraryApplication.switchToMainViewRemoveBook(p,b);
    }

    @FXML
    public void goAuthor() throws IOException {
        LibraryApplication.switchToAuthorView(b, p);
    }

    @FXML
    public void checkoutHardcover() throws IOException {
        PersonalBook temp = new PersonalBook(b);
        p.addCheckoutHardcover(temp);
        LibraryApplication.switchToCheckoutView(b.checkoutHardcover(p),p);
    }

    @FXML
    public void goToReviews() throws IOException {
        LibraryApplication.switchToReview(b,p);
    }

    @FXML
    public void goToRate() throws IOException {
        LibraryApplication.switchToRateView(b,p);
    }

    @FXML
    public void checkoutPaperback() throws IOException {
        PersonalBook temp = new PersonalBook(b);
        p.addCheckoutPaperback(temp);
        LibraryApplication.switchToCheckoutView(b.checkoutPaperback(p),p);
    }

    @FXML
    public void setBtnFavorite() throws IOException {
        System.out.println(p);
        p.addFavorite(b);
        LibraryApplication.switchToFavoriteView(p);
    }

    @FXML
    public void setBtnRemoveFavorite() throws IOException {
        p.removeFavorite(b);
        LibraryApplication.switchToFavoriteView(p);
    }


    @FXML
    public void setBtnWantToRead() throws IOException {
        p.addWantToRead(b);
        LibraryApplication.switchToWantToReadView(p);
    }

    public void setPerson(Person p){
        this.p=p;
    }

    @FXML
    public void returnHardcover() throws IOException {
            LibraryApplication.switchToCheckoutView(b.returnHardcover(p),p);
    }

    @FXML
    public void returnPaperback() throws IOException {
        LibraryApplication.switchToCheckoutView(b.returnPaperback(p),p);
    }

    @FXML
    public void setBtnDidNotFinish() throws IOException {
        p.addDidNotFinish(b);
        LibraryApplication.switchToDidNotFinishView(p);
    }

    @FXML
    public void setBtnFinish() throws IOException {
        p.removeDidNotFinish(b);
        LibraryApplication.switchToDidNotFinishView(p);
    }

    @FXML
    public void setBtnRenewHardcover() throws IOException {
        String message = b.renewHardcover(p);
        LibraryApplication.switchToRenewView(p, message);
    }

    @FXML
    public void setBtnRenewPaperback() throws IOException {
        String message = b.renewPaperback(p);
        LibraryApplication.switchToRenewView(p, message);
    }

    @FXML
    public void setBtnRemoveFromWantToRead() throws IOException {
        p.removeWantToRead(b);
        LibraryApplication.switchToWantToReadView(p);
    }

    public void setBook(Book b) {
        this.b = b;
        this.lblTitle.setText(b.getTitle());
        this.lblAuthor.setText(b.getAuthor().toString());
        this.lblBlurb.setText(b.getDescription());
        this.lblPaperbackCopies.setText(Integer.toString(b.getInvPaperback()));
        this.lblHardcoverCopies.setText(Integer.toString(b.getInvHardcover()));
        this.ratings.setText(Double.toString(b.getAvgRating()));
        this.publisher.setText(b.getPublisher());
        this.year.setText(Integer.toString(b.getReleaseYear()));
        this.citation.setText(b.getCitation());
        System.out.println(b.getAuthor());
    }



    @FXML
    public void initialize() {
    }
}
