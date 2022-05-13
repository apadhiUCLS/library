package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrowseController {

    @FXML
    private TableView table;

    @FXML
    private TableColumn titleColumn;

    @FXML
    private TableColumn authorColumn;

    @FXML
    private TableColumn copiesColumn;

    @FXML
    private Button checkedOutBooks;

    private Person p;

    @FXML
    private void showOverview() throws Exception {
        Book b = (Book) table.getSelectionModel().getSelectedItem();
        LibraryApplication.switchToOverview(b);
    }

    public void goCheckedOut() throws IOException {
        LibraryApplication.switchToCheckedOutBooks(p);
    }

    @FXML
    public void initialize() {
        List<Book> bookList = new ArrayList<Book>();
        Author HarperLee = new Author("Harper", "Lee");
        Author JKRowling = new Author("JK", "Rowling");
        Series harryPotter=new Series("Harry Potter");
        bookList.add(new Book("To Kill A MockingBird", HarperLee, 3,1));
        bookList.add(new Book("Sorcerer's Stone", JKRowling, 4,1,harryPotter));
        bookList.add(new Book("Chamber of Secrets", JKRowling, 4,1,harryPotter));
        bookList.add(new Book("Prisoner of Azkaban", JKRowling, 4,1,harryPotter));
        bookList.add(new Book("Goblet of Fire", JKRowling, 4,1,harryPotter));
        bookList.add(new Book("Order of the Phoenix", JKRowling, 4,1,harryPotter));
        bookList.add(new Book("Half-Blood Prince", JKRowling, 4,1,harryPotter));
        bookList.add(new Book("Deathly Hallows", JKRowling, 4,1,harryPotter));

        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        copiesColumn.setCellValueFactory(new PropertyValueFactory<>("Inventory"));
        table.setItems(FXCollections.observableList(bookList));
    }
    public void update(){
        table.refresh();
    }

}