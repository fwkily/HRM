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
    private int ri_Num;//人数
    private String ri_Intro;//简介
    private int ri_State;//状态0未发布，1发布，2失效
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ri_Date;//时间

    public Recruit_Information() {
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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

    public Job getJ_ob() {
        return job;
    }

    public void setJ_ob(Job j_ob) {
        this.job = j_ob;
    }

    public int getRi_Num() {
        return ri_Num;
    }

    public void setRi_Num(int ri_Num) {
        this.ri_Num = ri_Num;
    }

    public String getRi_Intro() {
        return ri_Intro;
    }

    public void setRi_Intro(String ri_Intro) {
        this.ri_Intro = ri_Intro;
    }

    public int getRi_State() {
        return ri_State;
    }

    public void setRi_State(int ri_State) {
        this.ri_State = ri_State;
    }

    public Date getRi_Date() {
        return ri_Date;
    }

    public void setRi_Date(Date ri_Date) {
        this.ri_Date = ri_Date;
    }

    @Override
    public String toString() {
        return "Recruit_Information{" +
                "ri_id=" + ri_id +
                ", department=" + department +
                ", j_ob=" + job +
                ", ri_Num=" + ri_Num +
                ", ri_Intro='" + ri_Intro + '\'' +
                ", ri_State=" + ri_State +
                ", ri_Date=" + ri_Date +
                '}';
    }
}
