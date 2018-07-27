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
    private User user;//用户
    private String ra_explain;//说明

    public Rap() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                ", ra_explain='" + ra_explain + '\'' +
                '}';
    }
}
