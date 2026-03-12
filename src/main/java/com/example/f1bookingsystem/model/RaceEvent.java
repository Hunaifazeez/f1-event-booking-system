package com.example.f1bookingsystem.model;

public class RaceEvent {

    private String raceName;
    private String location;
    private String date;

    public RaceEvent(String raceName, String location, String date) {
        this.raceName = raceName;
        this.location = location;
        this.date = date;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}