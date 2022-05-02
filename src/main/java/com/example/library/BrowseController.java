package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class BrowseController {

    @FXML
    private TableView table;

    @FXML
    private TableColumn titleColumn;

    @FXML
    private TableColumn authorColumn;

    private void showOverview(MouseEvent e) throws Exception {
        Book b = (Book) table.getSelectionModel().getSelectedItem();
        LibraryApplication.switchToOverview(b);
    }

    public void initialize() {
        List bookList = new ArrayList();
        Author HarperLee = new Author("Harper", "Lee");
        Author JKRowling = new Author("JK", "Rowling");
        bookList.add(new Book("To Kill A MockingBird", HarperLee));
        bookList.add(new Book("Harry Potter", JKRowling));

        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("column"));
        table.setItems(FXCollections.observableList(bookList));
    }


}