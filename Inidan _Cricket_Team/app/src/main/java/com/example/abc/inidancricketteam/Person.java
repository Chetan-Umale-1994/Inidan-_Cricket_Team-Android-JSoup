package com.example.abc.inidancricketteam;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String dob;
    private String place;
    private String role;
    private String batting_style;
    private String bowling_style;
    private String image;
    private String url;

    public Person(String name, String dob, String place,String role,String batting_style,String bowling_style, String image, String url) {
        this.name = name;
        this.dob = dob;
        this.place = place;
        this.role = role;
        this.batting_style = batting_style;
        this.bowling_style = bowling_style;
        this.image = image;
        this.url = url;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBatting_style() {
        return batting_style;
    }

    public void setBatting_style(String batting_style) {
        this.batting_style = batting_style;
    }

    public String getBowling_style() {
        return bowling_style;
    }

    public void setBowling_style(String bowling_style) {
        this.bowling_style = bowling_style;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
