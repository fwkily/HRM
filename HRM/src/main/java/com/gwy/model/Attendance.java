package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//考勤表
public class Attendance implements Serializable{
    private int a_id;//ID
    private Staff staff;//员工
    private Date a_date;//当前日期
    private Date on_time;//上班
    private Date off_time;//下班
    private int a_state;//状态默认0，正常上班1，加班2，迟到3，早退4 ，迟到加早退5，旷工 6

    public Attendance() {
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getA_date() {
        return a_date;
    }

    public void setA_date(Date a_date) {
        this.a_date = a_date;
    }

    public Date getOn_time() {
        return on_time;
    }

    public void setOn_time(Date on_time) {
        this.on_time = on_time;
    }

    public Date getOff_time() {
        return off_time;
    }

    public void setOff_time(Date off_time) {
        this.off_time = off_time;
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
                ", staff=" + staff +
                ", a_date=" + a_date +
                ", on_time=" + on_time +
                ", off_time=" + off_time +
                ", a_state=" + a_state +
                '}';
    }
}
