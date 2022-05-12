package com.example.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class LibraryApplication extends Application {
    private static Stage s;
    private static Scene home;
    private static FXMLLoader loader;
    @Override
    public void start(Stage stage) throws IOException {
        s=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryApplication.class.getResource("browse-view.fxml"));
        loader=fxmlLoader;
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        home=scene;
        s.setTitle("Hello!");
        s.setScene(home);
        s.show();
    }

    public static void switchToMainView() throws IOException {
/*        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("browse-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);*/
        BrowseController browseController = loader.getController();
        browseController.update();
        s.setScene(home); // the initialize method will get called in here
    }

    public static void switchToCheckoutView(String m) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("checkout-page.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        CheckoutController checkoutBook = loader.getController();
        checkoutBook.setLabel(m);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToCheckedOutBooks(Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("checked-out-books.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        CheckedOutBooksController listOfBooks = loader.getController();
        listOfBooks.setCheckedOutBooks(p.getCheckedOutBooks());
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToOverview(Book book) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("BookOverview.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        BookOverviewController bookController = loader.getController();
        bookController.setBook(book);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void main(String[] args) {
        launch();
    }
}