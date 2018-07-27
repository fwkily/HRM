package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//培训表
public class Cultivate implements Serializable {
    private int c_id;//ID
    private Staff staff;//培训人
    private Date c_date;//日期
    private String c_content;//内容
    private int c_state;//状态

    public Cultivate() {
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public int getC_state() {
        return c_state;
    }

    public void setC_state(int c_state) {
        this.c_state = c_state;
    }

    @Override
    public String toString() {
        return "Cultivate{" +
                "c_id=" + c_id +
                ", staff=" + staff +
                ", c_date=" + c_date +
                ", c_content='" + c_content + '\'' +
                ", c_state=" + c_state +
                '}';
    }
}
