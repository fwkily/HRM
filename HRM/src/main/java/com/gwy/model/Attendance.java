package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//考勤表
public class Attendance implements Serializable{
    private int a_id;//ID
    private User user;//用户
    private Date a_date;//当前日期
    private Date on_date;//上班
    private Date up_date;//下班
    private int a_state;//状态

    public Attendance() {
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getA_date() {
        return a_date;
    }

    public void setA_date(Date a_date) {
        this.a_date = a_date;
    }

    public Date getOn_date() {
        return on_date;
    }

    public void setOn_date(Date on_date) {
        this.on_date = on_date;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "a_id=" + a_id +
                ", user=" + user +
                ", a_date=" + a_date +
                ", on_date=" + on_date +
                ", up_date=" + up_date +
                ", a_state=" + a_state +
                '}';
    }
}
