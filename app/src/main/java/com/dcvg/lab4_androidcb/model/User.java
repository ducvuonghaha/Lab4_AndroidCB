package com.dcvg.lab4_androidcb.model;

public class User {
    private String fullname, phone;
    private int id;

    public User(String fullname, String phone) {
        this.fullname = fullname;
        this.phone = phone;
    }

    public User(String fullname, String phone, int id) {
        this.fullname = fullname;
        this.phone = phone;
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
