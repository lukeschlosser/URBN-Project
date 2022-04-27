package com.URBNProject.wearther.model;

public class Location {

    // Can possibly add more location details in the future for new versions. City/Region/etc.
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
