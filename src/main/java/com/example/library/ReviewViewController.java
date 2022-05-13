package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ReviewViewController {
    @FXML
    private TableView table;

    @FXML
    private TableColumn stars;

    @FXML
    private TableColumn review;

    private ArrayList<Rating> bookList;

    public void initialize(Book b) {
        bookList=b.getRatings();
        stars.setCellValueFactory(new PropertyValueFactory<>("stars"));
        review.setCellValueFactory(new PropertyValueFactory<>("review"));
        table.setItems(FXCollections.observableList(bookList));
    }
}
