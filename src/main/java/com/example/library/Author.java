package com.example.library;

import java.util.ArrayList;

public class Author implements java.io.Serializable{
    private String firstName;
    private String lastName;
    private ArrayList<Book> bookList;

    public Author (String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setFirstName(String name){
        this.firstName=name;
    }

    public void setLastName(String name){
        this.lastName=name;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return firstName+" "+lastName;
    }

    public ArrayList getBookList(){
        return bookList;
    }

    public void addBook(Book b){
        bookList.add(b);
    }

    public Book getBook(int index){
        return bookList.get(index);
    }

}
