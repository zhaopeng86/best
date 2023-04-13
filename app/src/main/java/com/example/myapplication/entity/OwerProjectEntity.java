package com.example.myapplication.entity;

public class OwerProjectEntity extends BaseDataEntity{

    private String username;
    private String mobilenumber;
    private String qrcode;
    private String commitinfo;
    private String projecttype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getCommitinfo() {
        return commitinfo;
    }

    public void setCommitinfo(String commitinfo) {
        this.commitinfo = commitinfo;
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype;
    }
}
