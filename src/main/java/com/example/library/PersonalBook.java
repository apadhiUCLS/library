package com.example.library;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PersonalBook extends Book implements java.io.Serializable {
    private Book b;
    private Author author;
    private String title;
    private Date returnDate;
    private String description;
    private int numPaperbackCheckedOut = 0;
    private int numHardcoverCheckedOut = 0;
    private double avgRating;
    private int numRatings = 0;
    private Series series;
    private int numInSeries;
    public ArrayList<Rating> ratings = new ArrayList<Rating>();
    private String callNum;
    private String genre;

    public PersonalBook(Book book) {
        b = book;
        author = book.getAuthor();
        title = book.getTitle();
        description = book.getDescription();
        avgRating = book.getAvgRating();
        numRatings = book.getRatings().size();
        series = book.getSeries();
        numInSeries = book.getNumInSeries();
        ratings = book.getRatings();
        callNum = book.getCallNum();
        genre = book.getGenre();
    }


    public Book getBook() {
        return b;
    }

    public int getNumHardcoverCheckedOut() {
        return numHardcoverCheckedOut;
    }

    public int getNumPaperbackCheckedOut() {
        return numPaperbackCheckedOut;
    }


    public void setNumHardcoverCheckedOut(int i) {
        numHardcoverCheckedOut = i;
    }

    public void setNumPaperbackCheckedOut(int i) {
        numPaperbackCheckedOut = i;
    }

    public ArrayList<Rating> getRatings(){
        return ratings;
    }

    public int getNumInSeries(){
        return numInSeries;
    }

    public String getGenre(){
        return genre;
    }

    public double getAvgRating(){
        return avgRating;
    }

    public String getTitle(){
        return title;
    }

    public Author getAuthor(){
        return author;
    }

    public String getDescription(){
        return description;
    }

    public Series getSeries(){
        return series;
    }

    public Date getReturnDate(){
        return returnDate;
    }

    public void setReturnDate(Date d) {
        returnDate = d;
    }

}

