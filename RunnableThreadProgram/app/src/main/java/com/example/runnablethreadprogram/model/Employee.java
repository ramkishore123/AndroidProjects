package com.example.runnablethreadprogram.model;

import java.io.Serializable;

public  class Employee implements Serializable{

    private String senderName;

    private String description;


    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee(String senderName, String description) {
        this.senderName = senderName;
        this.description = description;
    }
}
