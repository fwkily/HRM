package com.gwy.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//管理员
public class Admin implements Serializable{
    private int ad_id;//ID
    private String ad_name;//用户名
    private String ad_pass;//密码
    private Staff staff;//员工

    public Admin() {
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public String getAd_pass() {
        return ad_pass;
    }

    public void setAd_pass(String ad_pass) {
        this.ad_pass = ad_pass;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ad_id=" + ad_id +
                ", ad_name='" + ad_name + '\'' +
                ", ad_pass='" + ad_pass + '\'' +
                ", staff=" + staff +
                '}';
    }
}
