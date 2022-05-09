package com.example.library;

import java.util.Date;

public class Book {
    private Author author;
    private String title;
    private Date releaseDate;
    private Date returnDate;
    private String description;
    private int inventory;
    boolean checkedOut=false;

    public Book(String title, Author author){
        this.title=title;
        this.author=author;
        this.inventory=0;
    }

    public Book(String title, Author author, int inventory){
        this.title=title;
        this.author=author;
        this.inventory=inventory;
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

    public void setReturnDate(){
        returnDate=new Date();
        returnDate.setMonth(returnDate.getMonth()+1);
    }

    public int getInventory(){
        return inventory;
    }

    public void setInventory(int i){
        inventory= i;
    }

    public String checkout(){
        if (inventory>0 && checkedOut==false){
            inventory-=1;
            Person.addCheckout(this);
            checkedOut=true;
            setReturnDate();
            return "Checkout successful!";
        } else{
            return "No copies available:(";
        }
    }

    public String return(){
        return "s";
    }

}
