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

    public Date getReturnDate(){
        return returnDate;
    }

    public boolean isOverdue(){
        Date today=new Date();
        return returnDate.before(today);
    }

    public int getInventory(){
        return inventory;
    }

    public void setInventory(int i){
        inventory= i;
    }

    public String checkout(Person p){
        if (inventory>0 && checkedOut==false){
            inventory-=1;
            p.addCheckout(this);
            checkedOut=true;
            setReturnDate();
            if (p.inHolds(this)){
                p.removeHold(this);
            }
            return "Checkout successful!";
        } else{
            return "No copies available:(";
        }
    }

    public String returnBook(Person p){
        if (checkedOut==true){
            inventory +=1;
            p.returnBook(this);
            returnDate=null;
            return "Return successful!";
        } else{
            return "This book was not checked out, so you can't return it:(";
        }
    }

    public String renew(){
        if (checkedOut==true){
            setReturnDate();
            return "Renew successful!";
        } else{
            return "You need to check this book out before renewing it";
        }
    }

    public String hold(Person p){
        if (inventory==0){
            p.addHold(this);
            return "Hold successful";
        } else{
            return "There are copies available, so you can check this book out!";
        }
    }

}
