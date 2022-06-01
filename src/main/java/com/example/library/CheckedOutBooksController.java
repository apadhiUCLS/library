package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class CheckedOutBooksController {

    @FXML
    private TableView table;

    @FXML
    private TableColumn titleColumn;

    @FXML
    private TableColumn authorColumn;

    @FXML
    private TableColumn hardcoverCheckedOutColumn;

    @FXML
    private TableColumn paperbackCheckedOutColumn;

    @FXML
    private TableColumn seriesColumn;

    @FXML
    private TableColumn returnDateColumn;

    @FXML
    private TableColumn ratingsColumn;

    @FXML
    private Button backToBrowse;

    private ArrayList<PersonalBook> checkedOutBooks=new ArrayList<PersonalBook>();
    private Person p;
    @FXML
    public void goBack() throws IOException {
        LibraryApplication.switchToMainView(p);
    }

    public void setPerson(Person p){
        this.p = p;
        this.checkedOutBooks = p.getCheckedOutBooks();
        System.out.println("!!"+checkedOutBooks);


        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        hardcoverCheckedOutColumn.setCellValueFactory(new PropertyValueFactory<>("numHardcoverCheckedOut"));
        paperbackCheckedOutColumn.setCellValueFactory(new PropertyValueFactory<>("numPaperbackCheckedOut"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        ratingsColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        table.setItems(FXCollections.observableList(checkedOutBooks));
        this.update();
    }

    @FXML
    private void showOverview() throws Exception {
        Book b = (Book) table.getSelectionModel().getSelectedItem();
        LibraryApplication.switchToOverview(b,p);
    }

    @FXML
    public void initialize() throws IOException {
        /*
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        hardcoverCheckedOutColumn.setCellValueFactory(new PropertyValueFactory<>("numHardcoverCheckedOut"));
        paperbackCheckedOutColumn.setCellValueFactory(new PropertyValueFactory<>("numPaperbackCheckedOut"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        ratingsColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        table.setItems(FXCollections.observableList(checkedOutBooks));
        */
    }

    public void update() {
        table.refresh();
    }

}
