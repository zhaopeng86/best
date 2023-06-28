package com.example.myapplication.entity;

public class GameItemBean extends BaseDataEntity{

    private String imageUrl;
    private String des;
    private String detatle;

    private String clickUrl;

    public GameItemBean(String imageUrl, String des, int resId) {
        this.imageUrl = imageUrl;
        this.des = des;
        this.resId = resId;
    }

    private  int resId;

    public GameItemBean(String imageUrl, String des, String detatle, String clickUrl, int resId) {
        this.imageUrl = imageUrl;
        this.des = des;
        this.detatle = detatle;
        this.clickUrl = clickUrl;
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public GameItemBean(String imageUrl, String des, String detatle, String clickUrl) {
        this.imageUrl = imageUrl;
        this.des = des;
        this.detatle = detatle;
        this.clickUrl = clickUrl;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public GameItemBean(String imageUrl, String des, String detatle) {
        this.imageUrl = imageUrl;
        this.des = des;
        this.detatle = detatle;
    }

    public String getDetatle() {
        return detatle;
    }

    public void setDetatle(String detatle) {
        this.detatle = detatle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public GameItemBean(String imageUrl, String des) {
        this.imageUrl = imageUrl;
        this.des = des;
    }

    @Override
    public String getClassName() {
        return this.getClass().getName();
    }
}
