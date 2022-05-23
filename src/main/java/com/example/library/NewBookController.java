package com.example.library;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NewBookController {

    private Book b=new Book();

    @FXML
    private TextField title;
    @FXML
    private TextField authorFName;
    @FXML
    private TextField authorLName;
    @FXML
    private TextField paperInv;
    @FXML
    private TextField hardcoverInv;
    @FXML
    private TextField series;
    @FXML
    private TextField numInSeries;
    @FXML
    private TextField genre;
    @FXML
    private Button done;

    private Person p;

    public void setPerson(Person p){
        this.p=p;
    }


    public void doneButtonHandler() throws IOException {
        if (title.getText() != null && authorFName.getText() != null && authorLName.getText() != null && paperInv.getText() != null && hardcoverInv.getText() != null && series.getText() != null && numInSeries.getText() != null && genre.getText() != null) {
            b.setTitle(title.getText());
            b.setAuthor(new Author(authorFName.getText(), authorLName.getText()));
            b.setInvPaperback(Integer.parseInt(paperInv.getText()));
            b.setInvHardcover(Integer.parseInt(hardcoverInv.getText()));
            b.setGenre(genre.getText());
            for (int i=0; i<BrowseController.getBookList().size(); i++){
                if (authorFName.getText().equals(BrowseController.getBookList().get(i).getAuthor().getFirstName()) && authorLName.getText().equals(BrowseController.getBookList().get(i).getAuthor().getLastName())){
                    b.setAuthor(BrowseController.getBookList().get(i).getAuthor());
                }
                if (b.getAuthor()==null){
                    b.setAuthor(new Author(authorFName.getText(),authorLName.getText()));
                }
            }
            for (int i=0; i<BrowseController.getBookList().size(); i++){
                if (series.getText().equals(BrowseController.getBookList().get(i).getSeries().getTitle())){
                    b.setSeries(BrowseController.getBookList().get(i).getSeries());
                }
                if (b.getSeries()==null){
                    b.setSeries(new Series(series.getText(), new ArrayList<Book>()));
                }
            }

            BrowseController.addToBookList(b);
        }
        try {
            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.home") + "/.library/library.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(BrowseController.getBookList());
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        LibraryApplication.switchToMainView(p);
    }
}
