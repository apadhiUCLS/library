package com.example.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class  LibraryApplication extends Application {
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
        s.setTitle("Library Book Bonanza");
        s.setScene(home);
        s.setWidth(1000);
        s.setHeight(600);
        s.show();
    }

    public static void switchToMainView(Person p) throws IOException {
/*        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("browse-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);*/
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("browse-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        BrowseController browseController = loader.getController();
        browseController.setPerson(p);
        System.out.println(browseController.getBookList());
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToMainViewRemoveBook(Person p, Book b) throws IOException {
/*        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("browse-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);*/
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("browse-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        BrowseController browseController = loader.getController();
        browseController.setPerson(p);
        browseController.removeBook(b);
        System.out.println(browseController.getBookList());
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToMainView(Person p, ArrayList<Person> people) throws IOException {
/*        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("browse-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);*/
        BrowseController browseController = loader.getController();
        browseController.update();
        browseController.setPerson(p);
        s.setScene(home); // the initialize method will get called in here

        ChooseUserController.setUserList(people);
    }

    public static void switchToCheckoutView(String m, Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("checkout-page.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        CheckoutController checkoutBook = loader.getController();
        checkoutBook.setLabel(m);
        checkoutBook.setPerson(p);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToFavoriteView(Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("favorite-books.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        FavoritesController favoriteBooks = loader.getController();
        favoriteBooks.setPerson(p);
        favoriteBooks.update();
        System.out.println(p);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToChooseUser(Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("choose-user.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        ChooseUserController person = loader.getController();
        person.setPerson(p);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToSignUpView(Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("sign-up-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        SignUpController newPersonController = loader.getController();
        newPersonController.setPerson(p);
        newPersonController.setPeople(ChooseUserController.getUserList());
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToDidNotFinishView(Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("did-not-finish-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        DidNotFinishViewController didNotFinish = loader.getController();
        didNotFinish.setPerson(p);
        s.setScene(myScene); // the initialize method will get called in here
    }


    public static void switchToRateView(Book b, Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("rating-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        RatingController rate = loader.getController();
        rate.setBook(b);
        s.setScene(myScene); // the initialize method will get called in here
    }


    public static void switchToCheckedOutBooks(Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("checked-out-books.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        CheckedOutBooksController listOfBooks = loader.getController();
        //listOfBooks.update(); this doesn't seem to be doing anything (when it is included, excluded, moved nothing changes)
        listOfBooks.setPerson(p);
        System.out.println(p);
        System.out.println(p.getCheckedOutBooks());
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToWantToReadView(Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("want-to-read-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        WantToReadController wantToReadBooks = loader.getController();
        wantToReadBooks.setBooks(p.getWantToRead());
        wantToReadBooks.setPerson(p);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToOverview(Book book, Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("BookOverview.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        BookOverviewController bookController = loader.getController();
        bookController.setPerson(p);
        bookController.setBook(book);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToReview(Book book, Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("review-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        ReviewViewController reviewViewController = loader.getController();
        reviewViewController.setBook(book);
        reviewViewController.setPerson(p);
        reviewViewController.update();
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void switchToNew(Person p) throws IOException {
        FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("newBook.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        NewBookController newBookController = loader.getController();
        newBookController.setPerson(p);
        s.setScene(myScene); // the initialize method will get called in here
    }

    public static void main(String[] args) {
        launch();
    }
}