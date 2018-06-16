package com.psrapps.www.inventorymanagerapp;

/**
 * Created by poornashekarreddy.p on 29-11-2017.
 */

public class IModel {
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public IModel(String uid, String name, String quantity, String price) {
        this.uid = uid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    private String uid="";
    private String name="";
    private String quantity="";
    private String price="";
}
