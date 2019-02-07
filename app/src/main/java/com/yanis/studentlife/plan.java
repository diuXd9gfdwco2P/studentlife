package com.yanis.studentlife;

public class plan {
    private String id;
    private String name;
    private String place;
    private String date;
    private String phone;

    public plan(String id, String name, String place, String date, String phone) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.date = date;
        this.phone = phone;
    }

    public plan(String name, String place, String date, String phone) {
        this.name = name;
        this.place = place;
        this.date = date;
        this.phone = phone;
    }

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
}
