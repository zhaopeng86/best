package com.example.myapplication.entity;

public abstract class BaseDataEntity {
    private int id;
    private String uuid;
    private String add_time;
    private String update_time;
    private String ext_data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getExt_data() {
        return ext_data;
    }

    public void setExt_data(String ext_data) {
        this.ext_data = ext_data;
    }

    public abstract String getClassName();
}
