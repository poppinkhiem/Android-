package com.example.nguyentrungkhanhb17dccn343.model;

public class Teacher {
    static int temp=0;
    private int id;
    private String name;
    private int year;
    private String level;

    public Teacher(String name, int year, String level) {
        ++temp;
        this.id = temp;
        this.name = name;
        this.year = year;
        this.level = level;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
//thac sy tien sy pho sg gs
