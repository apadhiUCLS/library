package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class CheckedOutBooksController {

    @FXML
    private TableView table;

    @FXML
    private TableColumn titleColumn;

    @FXML
    private TableColumn authorColumn;

    @FXML
    private Button backToBrowse;

    private ArrayList<Book> checkedOutBooks;

    @FXML
    private void showOverview() throws Exception {
        Book b = (Book) table.getSelectionModel().getSelectedItem();
        LibraryApplication.switchToOverview(b);
    }

    public void setCheckedOutBooks(ArrayList<Book> checkedOutBooks){
        this.checkedOutBooks = checkedOutBooks;
    }

    @FXML
    public void initialize() {
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        table.setItems(FXCollections.observableList(checkedOutBooks));
    }

}
