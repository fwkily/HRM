package com.gwy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//培训表
public class Cultivate implements Serializable {
    private int c_id;//ID
    private String c_theme;//主题
    private String c_content;//内容
    private Date c_begintime;//开始时间
    private Date c_endtime;//结束时间
    private String c_address;//地址
    private int c_state;//状态
    private Date c_issuetime;//发布时间
    private List<Staff> staffList=new ArrayList<>();//培训对象

    public Cultivate() {
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_theme() {
        return c_theme;
    }

    public void setC_theme(String c_theme) {
        this.c_theme = c_theme;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public Date getC_begintime() {
        return c_begintime;
    }

    public void setC_begintime(Date c_begintime) {
        this.c_begintime = c_begintime;
    }

    public Date getC_endtime() {
        return c_endtime;
    }

    public void setC_endtime(Date c_endtime) {
        this.c_endtime = c_endtime;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public int getC_state() {
        return c_state;
    }

    public void setC_state(int c_state) {
        this.c_state = c_state;
    }

    public Date getC_issuetime() {
        return c_issuetime;
    }

    public void setC_issuetime(Date c_issuetime) {
        this.c_issuetime = c_issuetime;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public String toString() {
        return "Cultivate{" +
                "c_id=" + c_id +
                ", c_theme='" + c_theme + '\'' +
                ", c_content='" + c_content + '\'' +
                ", c_begintime=" + c_begintime +
                ", c_endtime=" + c_endtime +
                ", c_address='" + c_address + '\'' +
                ", c_state=" + c_state +
                ", c_issuetime=" + c_issuetime +
                ", staffList=" + staffList +
                '}';
    }
}
