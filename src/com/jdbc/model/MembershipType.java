package com.jdbc.model;

public class MembershipType {
    private int MSID;
    private String duration;
    private float price;

    public MembershipType(String duration, float price) {
        this.duration = duration;
        this.price = price;
    }

    public int getMSID() {
        return MSID;
    }

    public void setMSID(int MSID) {
        this.MSID = MSID;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
