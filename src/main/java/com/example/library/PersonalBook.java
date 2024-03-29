package com.example.library;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PersonalBook extends Book implements java.io.Serializable {
    private Date returnDate;
    private boolean overdue;
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

    public PersonalBook(Book book) throws IOException {
        super(book.getTitle(), book.getAuthor(), book.getSeries(), book.getNumInSeries(), book.getGenre());
        description = book.getDescription();
        avgRating = book.getAvgRating();
        numRatings = book.getRatings().size();
        numInSeries = book.getNumInSeries();
        ratings = book.getRatings();
        callNum = book.getCallNum();
        genre = book.getGenre();
        overdue = false;
        book.setReturnDate();
        returnDate = book.getReturnDate();
        System.out.println(returnDate);
    }


    public Book getBook() {
        return this;
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

    public boolean getOverdue(){return overdue;}


    public boolean checkOverdue(){
        Date temp = new Date();
        if (temp.after(returnDate)) {
            overdue = true;
        }
        return overdue;
    }

    public String renewHardcover() throws IOException {
        if (numHardcoverCheckedOut > 0){
            super.setReturnDate();

            super.serialize();
            return "Renew successful! The new due date is " + returnDate;
        } else{
            return "You need to check this book out before renewing it (PERSONAL BOOK)";
        }
    }

    public String renewPaperBack() throws IOException {
        if (numPaperbackCheckedOut > 0){
            super.setReturnDate();

            super.serialize();
            return "Renew successful! The new due date is " + returnDate;
        } else{
            return "You need to check this book out before renewing it (PERSONAL BOOK)";
        }
    }

}

