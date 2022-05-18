package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class ReviewViewController {
    @FXML
    private TableView table;

    @FXML
    private TableColumn stars;

    @FXML
    private TableColumn review;

    @FXML
    private Button back;

    private ArrayList<Rating> bookList;

    private Book b=new Book();

    public void setBook(Book book){
        this.b=book;
    }

    @FXML
    public void goBack() throws IOException {
        LibraryApplication.switchToOverview(b);
    }

    @FXML
    public void initialize() {
        bookList=b.getRatings();
        stars.setCellValueFactory(new PropertyValueFactory<>("stars"));
        review.setCellValueFactory(new PropertyValueFactory<>("review"));
        table.setItems(FXCollections.observableList(bookList));
    }

    @FXML
    public void update(){
        table.refresh();
    }
}


