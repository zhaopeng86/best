package com.example.myapplication.entity;

public class AdItem {

    private  String title;

    private String des;

    private String corn;

    public AdItem(String title, String des, String corn) {
        this.title = title;
        this.des = des;
        this.corn = corn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCorn() {
        return corn;
    }

    public void setCorn(String corn) {
        this.corn = corn;
    }
}
