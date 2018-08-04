package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//奖惩表
public class Rap implements Serializable{
    private int ra_id;//ID
    private Date ra_date;//奖惩时间
    private double ra_money;//金额
    private Staff staff;//用户
    private String ra_explain;//说明

    public Rap() {
    }

    public Rap(double ra_money, Staff staff, String ra_explain) {
        this.ra_money = ra_money;
        this.staff = staff;
        this.ra_explain = ra_explain;
    }

    public int getRa_id() {
        return ra_id;
    }

    public void setRa_id(int ra_id) {
        this.ra_id = ra_id;
    }

    public Date getRa_date() {
        return ra_date;
    }

    public void setRa_date(Date ra_date) {
        this.ra_date = ra_date;
    }

    public double getRa_money() {
        return ra_money;
    }

    public void setRa_money(double ra_money) {
        this.ra_money = ra_money;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getRa_explain() {
        return ra_explain;
    }

    public void setRa_explain(String ra_explain) {
        this.ra_explain = ra_explain;
    }

    @Override
    public String toString() {
        return "Rap{" +
                "ra_id=" + ra_id +
                ", ra_date=" + ra_date +
                ", ra_money=" + ra_money +
                ", staff=" + staff +
                ", ra_explain='" + ra_explain + '\'' +
                '}';
    }
}
