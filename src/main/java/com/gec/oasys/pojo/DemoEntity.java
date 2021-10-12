package com.gec.oasys.pojo;

import java.io.Serializable;

public class DemoEntity implements Serializable {

    private String id;
    private String username;
    private String sex;
    private String city;

    public DemoEntity() {
    }

    public DemoEntity(String id, String username, String sex, String city) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
