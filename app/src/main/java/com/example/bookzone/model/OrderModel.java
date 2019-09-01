package com.example.bookzone.model;

import java.io.Serializable;

public class OrderModel implements Serializable {
    String title;
    String location;
    String deliverLocation;
    String phonenumber;

    public OrderModel(String title, String location, String deliverLocation, String phonenumber) {
        this.title = title;
        this.location = location;
        this.deliverLocation = deliverLocation;
        this.phonenumber = phonenumber;
    }

    public OrderModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeliverLocation() {
        return deliverLocation;
    }

    public void setDeliverLocation(String deliverLocation) {
        this.deliverLocation = deliverLocation;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
