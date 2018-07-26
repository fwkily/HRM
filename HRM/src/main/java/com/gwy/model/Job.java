package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/25/0025.
 */
//职位表
public class Job implements Serializable{
    private int jid;//职位ID
    private String jname;//职位名
    private Department department;//部门
    private double jsalary;//基本工资

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public String getjname() {
        return jname;
    }

    public void setjname(String jname) {
        this.jname = jname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getjsalary() {
        return jsalary;
    }

    public void setjsalary(double jsalary) {
        this.jsalary = jsalary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jid=" + jid +
                ", jname='" + jname + '\'' +
                ", department=" + department +
                ", jsalary=" + jsalary +
                '}';
    }

    public Job() {
    }
}
