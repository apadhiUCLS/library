package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class AuthorViewController {
    @FXML
    private TableColumn title;
    @FXML
    private TableColumn date;
    @FXML
    private TableView table;

    private Author a;
    private Book b;
    private Person p;

    @FXML
    private Button back;

    private ArrayList<Book> bookList=new ArrayList<Book>();

    public void setPerson(Person p){
        this.p=p;
    }

    @FXML
    public void goBack() throws IOException {
        LibraryApplication.switchToMainView(p);
    }

    public void setBook(Book b){
        a=b.getAuthor();
        this.b=b;
        bookList=a.getBookList();
        System.out.println("!!"+a);
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        date.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        table.setItems(FXCollections.observableList(bookList));
    }

    public void initialize(){
    }
}
