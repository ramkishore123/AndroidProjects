package com.example.recyclerviewdemo.model;

import java.io.Serializable;

public class Email implements Serializable {

    private String senderName;
    private String subject;


    public Email(String senderName, String subject) {
        this.senderName = senderName;
        this.subject = subject;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
