package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class WantToReadController {

    @FXML
    private TableView table;

    @FXML
    private TableColumn titleColumn;

    @FXML
    private TableColumn authorColumn;

    @FXML
    private TableColumn ratingsColumn;

    @FXML
    private Button backToBrowse;

    private ArrayList<Book> books;

    @FXML
    public void goBack() throws IOException {
        LibraryApplication.switchToMainView();
    }

    public void setBooks(ArrayList<Book> books){
        this.books = books;
    }

    @FXML
    private void showOverview() throws Exception {
        Book b = (Book) table.getSelectionModel().getSelectedItem();
        LibraryApplication.switchToOverview(b);
    }

    @FXML
    public void initialize() {
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        ratingsColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        table.setItems(FXCollections.observableList(books));
    }
}
