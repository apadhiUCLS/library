package com.example.library;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Book implements java.io.Serializable {
    private Author author;
    private String title;
    //private Date releaseDate;
    private String publisher;
    private int releaseYear;
    private Date returnDate;
    private String description;
    private int inventory;
    private int invPaperback;
    private int invHardcover;
    boolean checkedOut = false;
    private int numPaperbackCheckedOut = 0;
    private int numHardcoverCheckedOut = 0;
    private int avgRating;
    private int numRatings = 0;
    private Series series;
    private int numInSeries;
    public ArrayList<Rating> ratings = new ArrayList<Rating>();
    private String callNum;
    private String genre;
    private String citation;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
        this.inventory = 0;
    }

    public Book() {
    }

    public String getCitation(){
        return this.determineCitation();
    }

    public void setCitation(String s){
        citation=s;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String s){
        publisher=s;
    }

    public String determineCitation(){
        String c=getAuthor().getLastName();
        c+=", ";
        c+=getAuthor().getFirstName();
        c+=". ";
        c+=getTitle();
        c+=". ";
        c+=releaseYear;
        c+=". ";
        c+=publisher;
        c+=", ";
        c+=releaseYear;
        c+=".";
        System.out.println(c);
        return c;
    }


    public String getCallNum() {
        return this.determineCallNum();
    }

    public void setCallNum(String s) {
        callNum = s;
    }

    public String determineCallNum() {
        String c = genre.toUpperCase(Locale.ROOT) + " ";
        String letters = "";
        if (author.getLastName().length() < 3) {
            letters = author.getLastName();
        } else {
            letters = author.getLastName().substring(0, 3);
        }
        c += letters;
        return c;
    }
    public Book(String title, Author author, int invPaperback, int invHardcover,String genre){
        this.title=title;
        this.author=author;
        this.invHardcover=invHardcover;
        this.invPaperback=invPaperback;
        inventory=invPaperback+invHardcover;
        this.genre=genre;
        callNum=determineCallNum();
        citation=determineCitation();
    }

    public Book(String title, Author author, int invPaperback, int invHardcover, Series series, int numInSeries, String genre, String publisher, int releaseYear){
            this.title = title;
            this.author = author;
            this.invHardcover = invHardcover;
            this.invPaperback = invPaperback;
            this.series = series;
            this.numInSeries = numInSeries;
            inventory = invPaperback + invHardcover;
            this.genre = genre;
            callNum = determineCallNum();
            this.publisher = publisher;
            this.releaseYear = releaseYear;
            citation = determineCitation();
    }
    public Book(String title, Author author, int invPaperback, int invHardcover, Series series, int numInSeries, String genre) {
        this.title = title;
        this.author = author;
        this.invHardcover = invHardcover;
        this.invPaperback = invPaperback;
        this.series = series;
        this.numInSeries = numInSeries;
        inventory = invPaperback + invHardcover;
        this.genre = genre;
        callNum = determineCallNum();
    }

    public Book(String title, Author author, Series series, int numInSeries, String genre) {
        this.title = title;
        this.author = author;
        this.series = series;
        this.numInSeries = numInSeries;
        this.genre = genre;
        callNum = determineCallNum();
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public int getNumInSeries() {
        return numInSeries;
    }

    public void setNumInSeries(int s) {
        numInSeries = s;
    }

    public void setGenre(String s) {
        genre = s;
    }

    public String getGenre() {
        return genre;
    }

    public double getAvgRating(){
        avgRating=0;
        for (Rating r: ratings){
            avgRating+=r.getStars();
        }
        if (ratings.size()>0){
            avgRating=avgRating/ratings.size();
        }
        return avgRating;
    }

    public void addRating(Rating r) {
        ratings.add(r);
        System.out.println(ratings);
        numRatings += 1;
        avgRating = (avgRating * (numRatings - 1) + r.getStars()) / numRatings;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setAuthor(Author a) {
        author = a;
    }

    public void setReleaseYear(int d){
        releaseYear=d;
    }
    //public void setReleaseDate(Date d) {
    //    releaseDate = d;
    //}

    public void setDescription(String d) {
        description = d;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    //public Date getReleaseDate() {
     //   return releaseDate;
    //}
    public int getReleaseYear(){
        return releaseYear;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series s) {
        this.series = s;
    }

    public void setReturnDate() throws IOException {
        returnDate = new Date();
        returnDate.setMonth(returnDate.getMonth() + 1);

        serialize();

    }

    public Date getReturnDate() {
        return returnDate;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int i) {
        inventory = i;
    }

    public int getInvPaperback() {
        return invPaperback;
    }

    public void setInvPaperback(int i) {
        invPaperback = i;
        inventory = invPaperback + invHardcover;
    }

    public int getInvHardcover() {
        return invHardcover;
    }

    public void setInvHardcover(int i) {
        invHardcover = i;
        inventory = invPaperback + invHardcover;
    }

    public int getNumHardcoverCheckedOut() {
        return numHardcoverCheckedOut;
    }

    public int getNumPaperbackCheckedOut() {
        return numPaperbackCheckedOut;
    }

    public String checkoutPaperback(Person p) throws IOException {
        ArrayList<Book> temp = BrowseController.getBookList();
        int i = temp.indexOf(this);

        if (invPaperback > 0) {
            invPaperback -= 1;
            checkedOut = true;
            numPaperbackCheckedOut += 1;
            setReturnDate();

            if (p.inHolds(this)) {
                p.removeHold(this);
            }

            if (p.inWantToRead(this) >= 0) {
                p.removeWantToRead(this);
            }
            inventory = invPaperback + invHardcover;
            try {
                String s = System.getProperty("user.home");
                FileOutputStream fileOut = new FileOutputStream(s + "/.library/library.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(temp);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in library.ser");
            } catch (IOException c) {
                c.printStackTrace();
            }
            return "Checkout successful! The return date is " + returnDate;
        } else {
            hold(p);
            return "No copies available:( Hold has been placed.";
        }
    }

    public String checkoutHardcover(Person p) throws IOException {
        ArrayList<Book> temp = BrowseController.getBookList();
        if (invHardcover > 0) {
            invHardcover -= 1;
            checkedOut = true;
            numHardcoverCheckedOut += 1;
            setReturnDate();
            if (p.inHolds(this)) {
                p.removeHold(this);
            }
            if (p.inWantToRead(this) >= 0) {
                p.removeWantToRead(this);
            }
            inventory = invPaperback + invHardcover;
            try {
                String s = System.getProperty("user.home");
                FileOutputStream fileOut = new FileOutputStream(s + "/.library/library.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(temp);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in library.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }
            return "Checkout successful! The return date is " + returnDate;
        } else {
            hold(p);
            return "No copies available:( Hold has been placed.";
        }
    }

    public String returnPaperback(Person p) {
        ArrayList<Book> temp = BrowseController.getBookList();
        if (numPaperbackCheckedOut > 0) {
            invPaperback += 1;
            p.returnPaperbackBook(this);
            returnDate = null;
            numPaperbackCheckedOut -= 1;
            inventory = invPaperback + invHardcover;
            try {
                String s = System.getProperty("user.home");
                FileOutputStream fileOut = new FileOutputStream(s + "/.library/library.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(temp);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in library.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }
            return "Return successful!";
        } else {
            return "This book was not checked out, so you can't return it:(";
        }
    }

    public String returnHardcover(Person p) {
        ArrayList<Book> temp = BrowseController.getBookList();
        if (numHardcoverCheckedOut > 0) {
            invHardcover += 1;
            p.returnHardcoverBook(this);
            returnDate = null;
            numHardcoverCheckedOut -= 1;
            inventory = invPaperback + invHardcover;
            try {
                String s = System.getProperty("user.home");
                FileOutputStream fileOut = new FileOutputStream(s + "/.library/library.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(temp);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in library.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }
            return "Return successful!";
        } else {
            return "This book was not checked out, so you can't return it:(";
        }
    }

    public void serialize() throws IOException {
        ArrayList<Book> temp = BrowseController.getBookList();
        try {
            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.home") + "/.library/library.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(temp);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


            public String renewHardcover(Person p) throws IOException {
                if (numHardcoverCheckedOut > 0) {
                    return p.renewHardcover(this);
                } else {
                    return "You need to check this book out before renewing it";
                }
            }

            public String renewPaperback(Person p) throws IOException {
                if (numPaperbackCheckedOut > 0) {

                    return p.renewPaperback(this);
                } else {
                    return "You need to check this book out before renewing it";
                }
            }


            public String hold (Person p){
                if (inventory == 0) {
                    p.addHold(this);
                    return "Hold successful";
                } else {
                    return "There are copies available, so you can check this book out!";
                }
            }

            public String getSeriesTitle () {

                if (series != null) {
                    return this.series.getSeriesTitle();
                }
                return "";
            }
        }