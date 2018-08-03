package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/25/0025.
 */
//职位表
public class Job implements Serializable{
    private int j_id;//职位ID
    private String j_name;//职位名
    private Department department;//部门
    private double j_salary;//基本工资

    public Job(int j_id) {
        this.j_id = j_id;
    }

    public Job() {
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getJ_salary() {
        return j_salary;
    }

    public void setJ_salary(double j_salary) {
        this.j_salary = j_salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "j_id=" + j_id +
                ", j_name='" + j_name + '\'' +
                ", department=" + department +
                ", j_salary=" + j_salary +
                '}';
    }
}
