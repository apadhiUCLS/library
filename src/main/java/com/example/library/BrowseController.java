package com.example.library;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private TableColumn callNumColumn;

    @FXML
    private Button checkedOutBooks;

    @FXML
    private Button favorites;

    @FXML
    private Button wantToRead;

    @FXML
    private Button newBook;

    private Path path;

    private static ArrayList<Book> bookList=new ArrayList<Book>();

    @FXML
    private Button didNotFinish;

    @FXML
    private Button chooseUser;

    private Person p;

    public Person getPerson(){
        return p;
    }

    public void setPerson(Person p){
        this.p = p;
    }

    public static ArrayList<Book> getBookList(){return bookList;}

    public static void addToBookList(Book b){bookList.add(b);}

    @FXML
    private void showOverview() throws Exception {
        Book b = (Book) table.getSelectionModel().getSelectedItem();
        LibraryApplication.switchToOverview(b, p);
    }

    @FXML
    public void goCheckedOut() throws IOException {
        LibraryApplication.switchToCheckedOutBooks(p);
    }

    public void setChooseUser() throws IOException {
        LibraryApplication.switchToChooseUser(p);
    }

    @FXML
    public void goFavorites() throws IOException {
        LibraryApplication.switchToFavoriteView(p);
    }

    @FXML
    public void goWantToRead() throws IOException {
        LibraryApplication.switchToWantToReadView(p);
    }

    @FXML
    public void goDidNotFinish() throws IOException {
        LibraryApplication.switchToDidNotFinishView(p);
    }

    public void goNewBook() throws IOException {
        LibraryApplication.switchToNew(p);
    }

    @FXML
    public void initialize() throws IOException {
/*        List<Book> bookList = new ArrayList<Book>();
        Author HarperLee = new Author("Harper", "Lee");
        Author JKRowling = new Author("JK", "Rowling");
        Series harryPotter=new Series("Harry Potter");
        bookList.add(new Book("To Kill A MockingBird", HarperLee, 3,1,"FICTION"));
        Book b1=new Book("Sorcerer's Stone", JKRowling, 4,1,harryPotter,1,"FICTION");
        harryPotter.addToSeries(b1);
        bookList.add(b1);
        Book b2=new Book("Chamber of Secrets", JKRowling, 4,1,harryPotter,2,"FICTION");
        bookList.add(b2);
        harryPotter.addToSeries(b2);
        Book b3=new Book("Prisoner of Azkaban", JKRowling, 4,1,harryPotter,3,"FICTION");
        bookList.add(b3);
        harryPotter.addToSeries(b3);
        Book b4=new Book("Goblet of Fire", JKRowling, 4,1,harryPotter,4,"FICTION");
        bookList.add(b4);
        harryPotter.addToSeries(b4);

        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        hardcoverColumn.setCellValueFactory(new PropertyValueFactory<>("invHardcover"));
        paperbackColumn.setCellValueFactory(new PropertyValueFactory<>("invPaperback"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("seriesTitle"));
        ratingsColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        callNumColumn.setCellValueFactory(new PropertyValueFactory<>("callNum"));
        table.setItems(FXCollections.observableList(bookList));*/
        path = FileSystems.getDefault().getPath(System.getProperty("user.home"), ".library");
        if (!Files.exists(path)){
            Path p=Files.createDirectory(path);
        }
        Book b = null;
        try {
            FileInputStream fileIn = new FileInputStream(path+"/library.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            bookList = (ArrayList<Book>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        hardcoverColumn.setCellValueFactory(new PropertyValueFactory<>("invHardcover"));
        paperbackColumn.setCellValueFactory(new PropertyValueFactory<>("invPaperback"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("seriesTitle"));
        ratingsColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        callNumColumn.setCellValueFactory(new PropertyValueFactory<>("callNum"));
        table.setItems(FXCollections.observableList(bookList));


    }
    public void update(){
        table.refresh();
    }

}