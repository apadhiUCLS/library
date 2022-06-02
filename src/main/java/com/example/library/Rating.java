package com.example.library;

import java.io.Serializable;

public class Rating implements Serializable {
    private String review;
    private int stars;

    public Rating(){}

    public Rating(String s, int i){
        review=s;
        stars=i;
    }
    public String toString(){
        return stars+" stars: "+review;
    }

    public int getStars(){
        return stars;
    }
    public String getReview(){
        return review;
    }

    public void setStars(int s){
        stars=s;
    }
    public void setReview(String r){
        review=r;
    }
}
