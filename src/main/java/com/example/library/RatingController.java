package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class RatingController {

    @FXML
    private Label lblTitle;

    @FXML
    private Button btnBack;

    @FXML
    private Button oneStar;

    @FXML
    private Button twoStar;

    @FXML
    private Button threeStar;

    @FXML
    private Button fourStar;

    @FXML
    private Button fiveStar;

    @FXML
    private TextArea  review;


    private Book b;

    private Rating r;

    @FXML
    public void goBack() throws IOException {
        if (r.getStars() >= 1 && r.getStars() <= 5) {
            b.addRating(r);
        }
        LibraryApplication.switchToOverview(b);
    }

    public void setBook(Book b) {
        this.b = b;
        this.lblTitle.setText(b.getTitle());
    }

    public void setOneStar() throws IOException {
        r.setStars(1);
    }

    public void setTwoStar() throws IOException {
        r.setStars(2);
    }

    public void setThreeStar() throws IOException {
        r.setStars(3);
    }

    public void setFourStar() throws IOException {
        r.setStars(4);
    }

    public void setFiveStar() throws IOException {
        r.setStars(5);
    }

    public void setReview() throws IOException {
        r.setReview(review.getText());
    }

}
