package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
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
    private TableColumn hardcoverColumn;

    @FXML
    private TableColumn paperbackColumn;

    @FXML
    private TableColumn seriesColumn;

    @FXML
    private TableColumn ratingsColumn;

    @FXML
    private Button checkedOutBooks;

    @FXML
    private Button favorites;

    @FXML
    private Button wantToRead;

    private Person p;

    @FXML
    private void showOverview() throws Exception {
        Book b = (Book) table.getSelectionModel().getSelectedItem();
        LibraryApplication.switchToOverview(b);
    }

    public void goCheckedOut() throws IOException {
        LibraryApplication.switchToCheckedOutBooks(p);
    }

    public void goFavorites() throws IOException {
        LibraryApplication.switchToFavoriteView(p);
    }

    public void goWantToRead() throws IOException {
        LibraryApplication.switchToWantToReadView(p);
    }

    @FXML
    public void initialize() {
        List<Book> bookList = new ArrayList<Book>();
        Author HarperLee = new Author("Harper", "Lee");
        Author JKRowling = new Author("JK", "Rowling");
        Series harryPotter=new Series("Harry Potter");
        bookList.add(new Book("To Kill A MockingBird", HarperLee, 3,1));
        bookList.add(new Book("Sorcerer's Stone", JKRowling, 4,1,harryPotter,1));
        bookList.add(new Book("Chamber of Secrets", JKRowling, 4,1,harryPotter,2));
        bookList.add(new Book("Prisoner of Azkaban", JKRowling, 4,1,harryPotter,3));
        bookList.add(new Book("Goblet of Fire", JKRowling, 4,1,harryPotter,4));
        bookList.add(new Book("Order of the Phoenix", JKRowling, 4,1,harryPotter,5));
        bookList.add(new Book("Half-Blood Prince", JKRowling, 4,1,harryPotter,6));
        bookList.add(new Book("Deathly Hallows", JKRowling, 4,1,harryPotter,7));

        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        hardcoverColumn.setCellValueFactory(new PropertyValueFactory<>("invHardcover"));
        paperbackColumn.setCellValueFactory(new PropertyValueFactory<>("invPaperback"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));
        ratingsColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        table.setItems(FXCollections.observableList(bookList));

    }
    public void update(){
        table.refresh();
    }

}