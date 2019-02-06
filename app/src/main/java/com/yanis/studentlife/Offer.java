package com.yanis.studentlife;

public class Offer {
    private String id;
    private String name;
    private String place;
    private String date;
    private String phone;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public Offer(String name, String place, String date, String phone) {
        this.name = name;
        this.place = place;
        this.date = date;
        this.phone = phone;
    }
}
