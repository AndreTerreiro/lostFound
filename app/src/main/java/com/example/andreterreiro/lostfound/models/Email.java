package com.example.andreterreiro.lostfound.models;

import io.realm.RealmObject;

public class Email extends RealmObject{
    private String mail;
    private boolean status;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
