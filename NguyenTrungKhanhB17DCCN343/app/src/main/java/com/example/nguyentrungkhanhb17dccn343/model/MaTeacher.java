package com.example.nguyentrungkhanhb17dccn343.model;

public class MaTeacher {
    static int temp =0;
    private int id;
    private int idTeacher;
    private int idMajor;
    private int year;

    public MaTeacher() {
    }

    public MaTeacher(int idTeacher, int idMajor, int year) {
        ++temp;
        this.idTeacher = idTeacher;
        this.idMajor = idMajor;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdMajor() {
        return idMajor;
    }

    public void setIdMajor(int idMajor) {
        this.idMajor = idMajor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

