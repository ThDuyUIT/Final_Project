package com.example.finalproject.myticket;

public class Ticket {
    private int resourceID;
    private String name;
    private String time;
    private String price;

    public Ticket(int resourceID, String name, String time, String price) {
        this.resourceID = resourceID;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public int getResourceID() {
        return resourceID;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
