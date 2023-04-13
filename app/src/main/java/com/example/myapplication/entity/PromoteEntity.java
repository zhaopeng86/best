package com.example.myapplication.entity;

public class PromoteEntity extends BaseDataEntity{

    private  String title;
    private  String description;
    private  String settlement;
    private  String price;
    private  String topprice;
    private  String allowance;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTopprice() {
        return topprice;
    }

    public void setTopprice(String topprice) {
        this.topprice = topprice;
    }

    public String getAllowance() {
        return allowance;
    }

    public void setAllowance(String allowance) {
        this.allowance = allowance;
    }
}
