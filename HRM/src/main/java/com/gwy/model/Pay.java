package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//薪资表
public class Pay implements Serializable{
    private int p_id;//ID
    private Date p_date;//日期
    private Staff staff;//员工
    private double p_base;//基本工资
    private double p_performance;//绩效奖金
    private double p_overtime;//加班工资
    private double p_rap;//奖惩
    private double p_ss;//社保
    private double p_pay;//实际工资
    private int p_state;//状态0生成，1正确，2复议，
    private String p_intro;//说明

    public Pay() {
    }

    public Pay(Staff staff, double p_base, double p_performance, double p_overtime, double p_rap, double p_ss, double p_pay, int p_state) {
        this.staff = staff;
        this.p_base = p_base;
        this.p_performance = p_performance;
        this.p_overtime = p_overtime;
        this.p_rap = p_rap;
        this.p_ss = p_ss;
        this.p_pay = p_pay;
        this.p_state = p_state;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public double getP_base() {
        return p_base;
    }

    public void setP_base(double p_base) {
        this.p_base = p_base;
    }

    public double getP_performance() {
        return p_performance;
    }

    public void setP_performance(double p_performance) {
        this.p_performance = p_performance;
    }

    public double getP_overtime() {
        return p_overtime;
    }

    public void setP_overtime(double p_overtime) {
        this.p_overtime = p_overtime;
    }

    public double getP_rap() {
        return p_rap;
    }

    public void setP_rap(double p_rap) {
        this.p_rap = p_rap;
    }

    public double getP_ss() {
        return p_ss;
    }

    public void setP_ss(double p_ss) {
        this.p_ss = p_ss;
    }

    public double getP_pay() {
        return p_pay;
    }

    public void setP_pay(double p_pay) {
        this.p_pay = p_pay;
    }

    public int getP_state() {
        return p_state;
    }

    public void setP_state(int p_state) {
        this.p_state = p_state;
    }

    public String getP_intro() {
        return p_intro;
    }

    public void setP_intro(String p_intro) {
        this.p_intro = p_intro;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "p_id=" + p_id +
                ", p_date=" + p_date +
                ", staff=" + staff +
                ", p_base=" + p_base +
                ", p_performance=" + p_performance +
                ", p_overtime=" + p_overtime +
                ", p_rap=" + p_rap +
                ", p_ss=" + p_ss +
                ", p_pay=" + p_pay +
                ", p_state=" + p_state +
                ", p_intro='" + p_intro + '\'' +
                '}';
    }
}
