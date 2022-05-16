package com.example.library;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<Book> books=new ArrayList<Book>();

    public Series (String title){
        this.title=title;
    }

    public Series(String title, ArrayList<Book> books){
        this.title=title;
        this.books=books;
    }

    public ArrayList<Book> getBooks(){
        return books;
    }

    public void addToSeries(Book b){
        books.add(b);
    }

    public void removeFromSeries(Book b){
        books.remove(b);
    }

    public String getSeriesTitle(){
        return title;
    }

    public int getNumBooks(){
        return books.size();
    }

    public ArrayList<Book> getSeries(){
        return books;
    }
}
