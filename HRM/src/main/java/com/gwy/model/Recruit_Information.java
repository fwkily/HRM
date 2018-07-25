package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public class Recruit_Information implements Serializable{
    private int riid;//招聘信息表ID
    private Department department;//部门
    private Job job;//职位
    private int riNum;//人数
    private String riIntro;//简介
    private int riState;//状态0未发布，1发布，2失效
    private String riDate;//时间

    public int getRiid() {
        return riid;
    }

    public void setRiid(int riid) {
        this.riid = riid;
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

    public int getRiNum() {
        return riNum;
    }

    public void setRiNum(int riNum) {
        this.riNum = riNum;
    }

    public String getRiIntro() {
        return riIntro;
    }

    public void setRiIntro(String riIntro) {
        this.riIntro = riIntro;
    }

    public int getRiState() {
        return riState;
    }

    public void setRiState(int riState) {
        this.riState = riState;
    }

    public String getRiDate() {
        return riDate;
    }

    public void setRiDate(String riDate) {
        this.riDate = riDate;
    }

    @Override
    public String toString() {
        return "Recruit_Information{" +
                "riid=" + riid +
                ", department=" + department +
                ", job=" + job +
                ", riNum=" + riNum +
                ", riIntro='" + riIntro + '\'' +
                ", riState=" + riState +
                ", riDate=" + riDate +
                '}';
    }

    public Recruit_Information() {
    }
}
