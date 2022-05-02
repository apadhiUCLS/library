package com.example.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class LibraryApplication extends Application {
    private static Stage s;
    @Override
    public void start(Stage stage) throws IOException {
        s=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        s.setTitle("Hello!");
        s.setScene(scene);
        s.show();
    }

    public void switchToMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("browse-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public void switchToOverview(Book book) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("BookOverview.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        BookOverviewController bookController=loader.getController();
        bookController.setBook(book);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void main(String[] args) {
        launch();
    }
}