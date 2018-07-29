package com.gwy.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/25/0025.
 */
//招聘信息表
public class Recruit_Information implements Serializable{
    private int ri_id;//招聘信息表ID
    private Department department;//部门
    private Job job;//职位
    private int ri_num;//人数
    private String ri_intro;//简介
    private int ri_state;//状态0未发布，1发布，2失效
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ri_date;//时间

    public Recruit_Information(int ri_id) {
        this.ri_id = ri_id;
    }

    public Recruit_Information() {
    }

    public int getRi_id() {
        return ri_id;
    }

    public void setRi_id(int ri_id) {
        this.ri_id = ri_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getRi_num() {
        return ri_num;
    }

    public void setRi_num(int ri_num) {
        this.ri_num = ri_num;
    }

    public String getRi_intro() {
        return ri_intro;
    }

    public void setRi_intro(String ri_intro) {
        this.ri_intro = ri_intro;
    }

    public int getRi_state() {
        return ri_state;
    }

    public void setRi_state(int ri_state) {
        this.ri_state = ri_state;
    }

    public Date getRi_date() {
        return ri_date;
    }

    public void setRi_date(Date ri_date) {
        this.ri_date = ri_date;
    }

    @Override
    public String toString() {
        return "Recruit_Information{" +
                "ri_id=" + ri_id +
                ", department=" + department +
                ", job=" + job +
                ", ri_num=" + ri_num +
                ", ri_intro='" + ri_intro + '\'' +
                ", ri_state=" + ri_state +
                ", ri_date=" + ri_date +
                '}';
    }
}
