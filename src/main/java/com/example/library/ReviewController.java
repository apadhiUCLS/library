package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ReviewController {

    @FXML
    private TableView table;

    @FXML
    private TableColumn starsColumn;

    @FXML
    private TableColumn reviewColumn;

    private ArrayList<Rating> bookRatings;

    public void setBookRatings(Book b){
        this.favoriteBooks = favoriteBooks;
    }

    @FXML
    public void initialize() {
        starsColumn.setCellValueFactory(new PropertyValueFactory<>("stars"));
        reviewColumn.setCellValueFactory(new PropertyValueFactory<>("review"));
        table.setItems(FXCollections.observableList(bookRatings));
    }

}
