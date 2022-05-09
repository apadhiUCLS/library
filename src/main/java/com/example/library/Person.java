package com.example.library;
import java.util.*;

public class Person {
    private ArrayList<Book>  checkedOutBooks;
    private ArrayList<Book>  heldBooks;
    private ArrayList<Book>  overdue;
    private String name;

    public Person(String name){
        this.checkedOutBooks = new ArrayList<Book>();
        this.heldBooks = new ArrayList<Book>();
        this.overdue = new ArrayList<Book>();
        this.name = name;
    }

    public ArrayList<Book> getCheckedOutBooks(){
        return checkedOutBooks;
    }

    public Person(){
        this.checkedOutBooks = new ArrayList<Book>();
        this.heldBooks = new ArrayList<Book>();
        this.overdue = new ArrayList<Book>();
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

    public boolean inHolds(Book book) {
        if (this.heldBooks.indexOf(book) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Book> getHolds() {return heldBooks;}
    public ArrayList<Book> getCheckedOut() {return checkedOutBooks;}
    public ArrayList<Book> getOverdue() {return overdue;}
    public String getName() {return name;}

    public void returnBook(Book book) {
        if (this.checkedOutBooks.indexOf(book) < 0) {
            this.checkedOutBooks.remove(checkedOutBooks.indexOf(book));
        }
        if (this.overdue.indexOf(book) < 0) {
            this.overdue.remove(overdue.indexOf(book));
        }
    }

    public boolean checkOverdue() {
        boolean existsOverdue = false;
        Date today = new Date();
        for (int i = 0; i < checkedOutBooks.size(); i++) {
            if (checkedOutBooks.get(i).getReleaseDate().compareTo(today) > 0) {
                existsOverdue = true;
                this.overdue.add(checkedOutBooks.get(i));
            }
        }
        return existsOverdue;
    }
}
