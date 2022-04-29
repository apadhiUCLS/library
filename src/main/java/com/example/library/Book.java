package com.example.library;

import java.util.Date;

public class Book {
    private Author author;
    private String title;
    private Date releaseDate;
    private String description;
    private int inventory;

    public Book(String title, Author author){
        this.title=title;
        this.author=author;
    }

    public void setTitle(String t){
        title=t;
    }
    public void setAuthor(Author a){
        author=a;
    }

    public void setReleaseDate(Date d){
        releaseDate=d;
    }

    public void setDescription(String d){
        description=d;
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

    public Date getReleaseDate(){
        return releaseDate;
    }

}
