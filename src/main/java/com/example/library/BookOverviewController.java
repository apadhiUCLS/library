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
    private Button btnWantToRead;
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
    private Button btnReview;
    @FXML
    private Button btnRate;
    @FXML
    private Button btnDidNotFinish;
    @FXML
    private Button btnFinish;

    @FXML
    private Label callNum;
    private Book b;

    private Person p;

    @FXML
    public void goBack() throws IOException {
         LibraryApplication.switchToMainView(p);
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
        //LibraryApplication.switchToDidNotFinishView(p);
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
    }


    @FXML
    public void initialize() {
    }
}
