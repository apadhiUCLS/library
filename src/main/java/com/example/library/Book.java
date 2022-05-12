package com.example.library;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Book {
    private Author author;
    private String title;
    private Date releaseDate;
    private Date returnDate;
    private String description;
    private int inventory;
    private int invPaperback;
    private int invHardcover;
    boolean checkedOut=false;
    private int numPaperbackCheckedOut=0;
    private int numHardcoverCheckedOut=0;
    private Rating rating;

    public Book(String title, Author author){
        this.title=title;
        this.author=author;
        this.inventory=0;
    }

    public Book(String title, Author author, int invPaperback, int invHardcover){
        this.title=title;
        this.author=author;
        this.invHardcover=invHardcover;
        this.invPaperback=invPaperback;
        inventory=invPaperback+invHardcover;
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

    public int getInvPaperback(){
        return invPaperback;
    }

    public void setInvPaperback(int i){
        invPaperback = i;
        inventory=invPaperback+invHardcover;
    }

    public int getInvHardcover(){
        return invHardcover;
    }

    public void setInvHardcover(int i){
        invHardcover= i;
        inventory=invPaperback+invHardcover;
    }

    public String checkoutPaperback(Person p){
        if (invPaperback>0){
            invPaperback-=1;
            p.addCheckout(this);
            checkedOut=true;
            numPaperbackCheckedOut+=1;
            setReturnDate();
            if (p.inHolds(this)){
                p.removeHold(this);
            }
            inventory=invPaperback+invHardcover;
            return "Checkout successful! The return date is " +returnDate;
        } else{
            hold(p);
            return "No copies available:( Hold has been placed.";
        }
    }

    public String checkoutHardcover(Person p){
        if (invHardcover>0){
            invHardcover-=1;
            p.addCheckout(this);
            checkedOut=true;
            numHardcoverCheckedOut+=1;
            setReturnDate();
            if (p.inHolds(this)){
                p.removeHold(this);
            }
            inventory=invPaperback+invHardcover;
            return "Checkout successful! The return date is " +returnDate;
        } else{
            hold(p);
            return "No copies available:( Hold has been placed.";
        }
    }

    public String returnPaperback(Person p){
        if (numPaperbackCheckedOut>0){
            invPaperback +=1;
            p.returnBook(this);
            returnDate=null;
            numPaperbackCheckedOut-=1;
            inventory=invPaperback+invHardcover;
            return "Return successful!";
        } else{
            return "This book was not checked out, so you can't return it:(";
        }
    }

    public String returnHardcover(Person p){
        if (numHardcoverCheckedOut>0){
            invPaperback +=1;
            p.returnBook(this);
            returnDate=null;
            numHardcoverCheckedOut-=1;
            inventory=invPaperback+invHardcover;
            return "Return successful!";
        } else{
            return "This book was not checked out, so you can't return it:(";
        }
    }

    public  void serialize() throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.home") + "/.library/settings.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
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
