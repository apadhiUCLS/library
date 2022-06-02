package com.example.library;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Person implements java.io.Serializable {
    private ArrayList<Book> wantToRead;
    private ArrayList<PersonalBook> checkedOutBooks;
    private ArrayList<Book> heldBooks;
    private ArrayList<Book> overdue;
    private ArrayList<Book> favorites;
    private String name;
    private ArrayList<Book> didNotFinish;


    public Person(String name) throws FileNotFoundException, IOException {
        this.checkedOutBooks = new ArrayList<PersonalBook>();
        this.heldBooks = new ArrayList<Book>();
        this.overdue = new ArrayList<Book>();
        this.wantToRead = new ArrayList<Book>();
        this.favorites = new ArrayList<Book>();
        this.name = name;
        this.didNotFinish = new ArrayList<Book>();
    }

    public void addFavorite(Book b) {
        favorites.add(b);
        System.out.println(this + " ");
        System.out.println(favorites);
        this.reserialize();
    }

    public void removeFavorite(Book b) {
        favorites.remove(b);
        this.reserialize();
    }

    public ArrayList<Book> getFavorites() {
        return favorites;
    }

    public ArrayList<PersonalBook> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public Person() throws FileNotFoundException, IOException {
        this.checkedOutBooks = new ArrayList<PersonalBook>();
        this.heldBooks = new ArrayList<Book>();
        this.overdue = new ArrayList<Book>();
        this.wantToRead = new ArrayList<Book>();
        this.didNotFinish = new ArrayList<Book>();
        this.favorites = new ArrayList<Book>();
        this.name = "anonymous";
    }


    public void addCheckoutPaperback(PersonalBook book) {
        boolean contains = false;
        for (int i = 0; i < checkedOutBooks.size(); i++) {
            if (book.getTitle().equals(checkedOutBooks.get(i).getTitle())) {
                checkedOutBooks.get(i).setNumPaperbackCheckedOut(checkedOutBooks.get(i).getNumPaperbackCheckedOut() + 1);
                System.out.println(book.getNumPaperbackCheckedOut());
                contains = true;
                break;
            }
        }
        if (!contains) {
            checkedOutBooks.add(book);
            book.setNumPaperbackCheckedOut(1);
        }
        if (this.heldBooks.indexOf(book) > 0) {
            removeHold(book.getBook());
        }
        if (this.wantToRead.indexOf(book) > 0) {
            this.removeWantToRead(book.getBook());
        }


        //this is the stuff to reserialize because I assume it is needed after changing a person in the list,
        //but is there anything else I need to do to make sure the changes are save and do I need to do this at all?
        ArrayList<Person> p = ChooseUserController.getUserList();
        String home = System.getProperty("user.home");
        Path folderPath = Paths.get(home + "/.libraryUsers");
        try {
            FileOutputStream fileOut = new FileOutputStream(folderPath + "/users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in users.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void addCheckoutHardcover(PersonalBook book) {
        boolean contains = false;
        for (int i = 0; i < checkedOutBooks.size(); i++) {
            if (book.getTitle().equals(checkedOutBooks.get(i).getTitle())) {
                checkedOutBooks.get(i).setNumHardcoverCheckedOut(checkedOutBooks.get(i).getNumHardcoverCheckedOut() + 1);
                contains = true;
                break;
            }
        }
        if (!contains) {
            checkedOutBooks.add(book);
            book.setNumHardcoverCheckedOut(1);
        }

        if (this.heldBooks.indexOf(book) > 0) {
            removeHold(book.getBook());
        }
        if (this.wantToRead.indexOf(book) > 0) {
            this.removeWantToRead(book.getBook());
        }


    //this is the stuff to reserialize because I assume it is needed after changing a person in the list,
    //but is there anything else I need to do to make sure the changes are save and do I need to do this at all?
    ArrayList<Person> p = ChooseUserController.getUserList();
    String home = System.getProperty("user.home");
    Path folderPath = Paths.get(home + "/.libraryUsers");
        try

    {
        FileOutputStream fileOut = new FileOutputStream(folderPath + "/users.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(p);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved in users.ser");
    } catch(
    IOException i)

    {
        i.printStackTrace();
    }

}

    public void addHold(Book book) {
        heldBooks.add(book);
        this.reserialize();
    }

    public void removeHold(Book book) {
        int index = this.heldBooks.indexOf(book);
        this.heldBooks.remove(index);
        this.reserialize();
    }

    public boolean inHolds(Book book) {
        if (this.heldBooks.indexOf(book) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Book> getHolds() {return heldBooks;}
    public ArrayList<Book> getOverdue() {return overdue;}
    public String getName() {return name;}

    public void returnHardcoverBook(Book book) {
        String title = book.getTitle();
        for ( int i = 0; i < checkedOutBooks.size(); i++) {
            String tempT = checkedOutBooks.get(i).getBook().getTitle();
            if (title.equals(tempT)) {
                if (checkedOutBooks.get(i).getNumHardcoverCheckedOut() > 0) {
                    checkedOutBooks.get(i).setNumHardcoverCheckedOut(checkedOutBooks.get(i).getNumHardcoverCheckedOut() - 1);
                }
                if (checkedOutBooks.get(i).getNumHardcoverCheckedOut() == 0 && checkedOutBooks.get(i).getNumPaperbackCheckedOut() == 0) {
                    checkedOutBooks.remove(i);
                    break;
                }
            }
        }
        if (this.overdue.indexOf(book) >= 0) {
            overdue.remove(overdue.indexOf(book));
        }

        this.reserialize();
    }


    public void returnPaperbackBook(Book book) {
        String title = book.getTitle();
        for ( int i = 0; i < checkedOutBooks.size(); i++) {
            String tempT = checkedOutBooks.get(i).getBook().getTitle();
            if (title.equals(tempT)) {
                if (checkedOutBooks.get(i).getNumPaperbackCheckedOut() > 0) {
                    checkedOutBooks.get(i).setNumPaperbackCheckedOut(checkedOutBooks.get(i).getNumPaperbackCheckedOut() - 1);
                }
                if (checkedOutBooks.get(i).getNumHardcoverCheckedOut() == 0 && checkedOutBooks.get(i).getNumPaperbackCheckedOut() == 0) {
                    checkedOutBooks.remove(i);
                    break;
                }
            }
        }
        if (this.overdue.indexOf(book) >= 0) {
            overdue.remove(overdue.indexOf(book));
        }

        this.reserialize();
    }

    public boolean checkOverdue() {
        boolean existsOverdue = false;
        Date today = new Date();
        for (int i = 0; i < checkedOutBooks.size(); i++) {
            if (checkedOutBooks.get(i).getBook().getReleaseDate().compareTo(today) > 0) {
                existsOverdue = true;
                this.overdue.add(checkedOutBooks.get(i).getBook());
            }
        }
        return existsOverdue;
    }

    public ArrayList<Book> getWantToRead(){
        return this.wantToRead;
    }

    public void addWantToRead(Book b){
        this.wantToRead.add(b);

        this.reserialize();
    }

    public void removeWantToRead(Book b) {
        int index = this.wantToRead.indexOf(b);
        this.wantToRead.remove(index);

        this.reserialize();
    }

    public void clearWantToRead() {
        this.wantToRead = new ArrayList<Book>();

        this.reserialize();
    }

    public void addDidNotFinish(Book b) {
        if (this.didNotFinish.indexOf(b) < 0) {
            this.didNotFinish.add(b);
        }
        if (this.wantToRead.indexOf(b) > 0) {
            this.wantToRead.remove(this.wantToRead.indexOf(b));

            this.reserialize();
        }
    }

    public void removeDidNotFinish(Book b) {
        int index = this.didNotFinish.indexOf(b);
        this.didNotFinish.remove(index);

        this.reserialize();
    }

    public ArrayList<Book> getDidNotFinish(){
        return this.didNotFinish;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public void reserialize() {
        ArrayList<Person> p = ChooseUserController.getUserList();
        String home = System.getProperty("user.home");
        Path folderPath = Paths.get(home + "/.libraryUsers");
        try {
            FileOutputStream fileOut = new FileOutputStream(folderPath + "/users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in users.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
