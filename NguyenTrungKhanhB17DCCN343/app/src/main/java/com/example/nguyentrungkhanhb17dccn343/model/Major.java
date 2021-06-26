package com.example.nguyentrungkhanhb17dccn343.model;

public class Major {
    static  int temp =0;
    private int id;
    private String name;
    private String des;

    public Major() {

    }

    public Major(String name, String des) {
        ++temp;
        this.id = temp;
        this.name = name;
        this.des = des;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
//ma ten mo ta phan mem tlap trinh nhung phan tich du luey an toan thong tin