package com.gwy.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/25/0025.
 */

public class User implements Serializable{
    private int uid;
    private String uName;
    private String uPass;

    public User(String uName, String uPass) {
        this.uName = uName;
        this.uPass = uPass;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uName='" + uName + '\'' +
                ", uPass='" + uPass + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uName;
    }

    public void setUname(String uName) {
        this.uName = uName;
    }

    public String getUpass() {
        return uPass;
    }

    public void setUpass(String uPass) {
        this.uPass = uPass;
    }
}
