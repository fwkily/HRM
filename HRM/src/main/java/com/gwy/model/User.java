package com.gwy.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/25/0025.
 */
//用户表
public class User implements Serializable{
    private int uid;//用户ID
    private String uname;//用户名
    private String upass;//用户密码

    public User(String uname, String upass) {
        this.uname = uname;
        this.upass = upass;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }
}
