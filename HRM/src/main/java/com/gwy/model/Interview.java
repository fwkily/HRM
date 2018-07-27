package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//面试
public class Interview implements Serializable{
    private int i_id;//ID
    private User user;//面试人
    private Recruit_Information recruit_Information;//面试职位信息；
    private int i_state;//状态
    private Date i_date;//面试时间
    private String i_address;//面试地址
    private String i_intro;//注意事项
    private Staff staff;//面试官

    public Interview() {
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recruit_Information getRecruit_Information() {
        return recruit_Information;
    }

    public void setRecruit_Information(Recruit_Information recruit_Information) {
        this.recruit_Information = recruit_Information;
    }

    public int getI_state() {
        return i_state;
    }

    public void setI_state(int i_state) {
        this.i_state = i_state;
    }

    public Date getI_date() {
        return i_date;
    }

    public void setI_date(Date i_date) {
        this.i_date = i_date;
    }

    public String getI_address() {
        return i_address;
    }

    public void setI_address(String i_address) {
        this.i_address = i_address;
    }

    public String getI_intro() {
        return i_intro;
    }

    public void setI_intro(String i_intro) {
        this.i_intro = i_intro;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "i_id=" + i_id +
                ", user=" + user +
                ", recruit_Information=" + recruit_Information +
                ", i_state=" + i_state +
                ", i_date=" + i_date +
                ", i_address='" + i_address + '\'' +
                ", i_intro='" + i_intro + '\'' +
                ", staff=" + staff +
                '}';
    }
}
