package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/25/0025.
 */
//部门表
public class Department implements Serializable{
    private int did;//部门ID
    private String dname;//部门名
    private Date ddate;//创建日期

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getdname() {
        return dname;
    }

    public void setdname(String dname) {
        this.dname = dname;
    }

    public Date getddate() {
        return ddate;
    }

    public void setddate(Date ddate) {
        this.ddate = ddate;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", ddate=" + ddate +
                '}';
    }

    public Department() {
    }
}
