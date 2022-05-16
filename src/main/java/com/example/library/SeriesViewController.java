package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;

import java.io.IOException;

public class SeriesViewController {
    @FXML
    private Button backBtn;
    @FXML
    private TableColumn numberColumn;
    @FXML
    private TableColumn titleColumn;
    @FXML
    private Label authorLbl;
    @FXML
    private TableView table;
    private Series bookSeries;

    @FXML
    public void backToBrowse() throws IOException {
        LibraryApplication.switchToMainView();
    }

    @FXML
    public void setBook(Book book) {
        this.bookSeries = book.getSeries();
        this.authorLbl.setText(book.getAuthor().toString());
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<> ("numInSeries"));
        table.setItems(FXCollections.observableList(book.getSeries().getBooks()));
    }

    @FXML
    private void showOverview() throws Exception {
        Book b = (Book) table.getSelectionModel().getSelectedItem();
        LibraryApplication.switchToOverview(b);
    }

    @FXML
    public void initialize() {}
}
