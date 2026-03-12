package com.example.f1bookingsystem.model;

public class Booking {

    private String raceName;
    private String userName;

    public Booking(String raceName, String userName) {
        this.raceName = raceName;
        this.userName = userName;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getUserName() {
        return userName;
    }
}