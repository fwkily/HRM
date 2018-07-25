package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public class Job implements Serializable{
    private int jid;
    private String jName;
    private Department department;
    private double jSalary;

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getjSalary() {
        return jSalary;
    }

    public void setjSalary(double jSalary) {
        this.jSalary = jSalary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jid=" + jid +
                ", jName='" + jName + '\'' +
                ", department=" + department +
                ", jSalary=" + jSalary +
                '}';
    }

    public Job() {
    }
}
