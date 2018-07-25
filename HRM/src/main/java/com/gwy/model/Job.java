package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public class Job implements Serializable{
    private int jid;
    private String jname;
    private Department department;
    private double jsalary;

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
