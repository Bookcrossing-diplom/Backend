package com.bookcrossing.model;

public class BookModel {
    String name;
    String firstname;
    String lastname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookModel(String name, String firstname, String lastname) {
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public BookModel() {
    }




    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
