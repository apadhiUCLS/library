package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NewBookController {

    private Book b=null;

    @FXML
    private TextField title;
    @FXML
    private TextField authorFName;
    @FXML
    private TextField authorLName;
    @FXML
    private TextField paperInv;
    @FXML
    private TextField hardcoverInv;
    @FXML
    private TextField series;
    @FXML
    private TextField numInSeries;
    @FXML
    private TextField Genre;
    @FXML
    private Button done;


    public void doneButtonHandler() throws IOException {
        if (title.getText() != null && authorFName.getText() != null && authorLName.getText() != null && paperInv.getText() != null && hardcoverInv.getText() != null && series.getText() != null && numInSeries.getText() != null && genre.getText() != null) {
            b.setTitle(title.getText());
            b.setAuthor(new Author(authorFName.getText(), authorLName.getText()));
            b.setInvPaperback(Integer.parseInt(paperInv.getText()));
            b.setInvHardcover(Integer.parseInt(hardcoverInv.getText()));

        }
    }
}
