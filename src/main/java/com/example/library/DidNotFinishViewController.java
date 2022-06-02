package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.*;

import java.io.IOException;

public class DidNotFinishViewController {
    @FXML
    private TableView table;
    @FXML
    private TableColumn titleColumn;
    @FXML
    private TableColumn authorColumn;
    @FXML
    private Button back;
    private Person p;
    private ArrayList<Book> didNotFinishBooks;

    @FXML
    public void backToBrowse() throws IOException {
        LibraryApplication.switchToMainView(p);
    }

    public void setPerson(Person p){
        this.p= p;
        this.didNotFinishBooks = this.p.getDidNotFinish();
        System.out.println("!!"+didNotFinishBooks);

        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        table.setItems(FXCollections.observableList(didNotFinishBooks));
    }

    @FXML
    private void showOverview() throws IOException {
        Book b = (Book) table.getSelectionModel().getSelectedItem();
        LibraryApplication.switchToOverview(b, p);
    }

    @FXML
    public void initialize(){}
}
