package com.example.library;
import java.util.*;

public class Person {
    private ArrayList<Book>  checkedOutBooks;
    private ArrayList<Book>  heldBooks;
    private String name;

    public Person(String name){
        this.checkedOutBooks = new ArrayList<Book>();
        this.heldBooks = new ArrayList<Book>();
        this.name = name;
    }

    public Person(){
        this.checkedOutBooks = new ArrayList<Book>();
        this.heldBooks = new ArrayList<Book>();
        this.name = "anonymous";
    }

    public void addCheckout(Book book) {
        checkedOutBooks.add(book);
    }

    public void addHold(Book book) {
        heldBooks.add(book);
    }

    public void returnBook(Book book) {
        int index = this.checkedOutBooks.indexOf(book);
    }
}
