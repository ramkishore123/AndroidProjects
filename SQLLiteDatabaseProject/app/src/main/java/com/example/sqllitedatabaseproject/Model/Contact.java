package com.example.sqllitedatabaseproject.Model;

public class Contact {

    private int ID;
    private String name;
    private String phoneNumber;


    public Contact(String name, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {

    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
