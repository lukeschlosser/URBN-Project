package com.URBNProject.wearther.model;

public class Location {
    private int postalCode;
    private String key;

    public Location(){}

    public Location(int postalCode){
        this.postalCode = postalCode;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

}
