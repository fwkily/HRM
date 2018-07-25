package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public class Department implements Serializable{
    private int did;
    private String dName;
    private Date dDate;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dName='" + dName + '\'' +
                ", dDate=" + dDate +
                '}';
    }

    public Department() {
    }
}
