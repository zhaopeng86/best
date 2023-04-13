package com.example.myapplication.entity;

public class ResponseData {
    private int ret;
    private Data data;
    private String msg;
    private int _t;
    private String _auth;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int get_t() {
        return _t;
    }

    public void set_t(int _t) {
        this._t = _t;
    }

    public String get_auth() {
        return _auth;
    }

    public void set_auth(String _auth) {
        this._auth = _auth;
    }
}
