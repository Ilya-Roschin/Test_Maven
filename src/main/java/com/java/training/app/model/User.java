package com.java.training.app.model;

public class User {

    private final int ID;
    private final String USER_NAME;
    private final int AGE;


    public User(int id, String userName, int age) {
        this.ID = id;
        this.USER_NAME = userName;
        this.AGE = age;
    }

    public int getID() {
        return ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public int getAGE() {
        return AGE;
    }
}
