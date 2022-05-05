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
        if (this.heldBooks.indexOf(book) < 0) {
            removeHold(book);
        }
    }

    public void addHold(Book book) {
        heldBooks.add(book);
    }

    public void removeHold(Book book) {
        int index = this.heldBooks.indexOf(book);
        this.heldBooks.remove(index);
    }

    public void returnBook(Book book) {
        int index = this.checkedOutBooks.indexOf(book);
        this.checkedOutBooks.remove(index);
    }
}
