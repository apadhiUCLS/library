package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class FavoritesController {

    @FXML
    private TableView table;

    @FXML
    private TableColumn titleColumn;

    @FXML
    private TableColumn authorColumn;

    @FXML
    private Button backToBrowse;

    private ArrayList<Book> favoriteBooks;

    @FXML
    public void goBack() throws IOException {
        LibraryApplication.switchToMainView();
    }

    public void setFavoriteBooks(ArrayList<Book> favoriteBooksBooks){
        this.favoriteBooks = favoriteBooks;
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
        table.setItems(FXCollections.observableList(favoriteBooks));
    }
}
