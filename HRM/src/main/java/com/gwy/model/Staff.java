package com.gwy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//员工表
public class Staff implements Serializable{
    private int s_id;//ID
    private String s_username;//用户名
    private String s_pass;//密码
    private Department department;//部门
    private Job job;//职位
    private int s_state;//在职状态
    private String s_name;//名字
    private String s_sex;//性别
    private String s_idcardno;//身份证号
    private Date s_birthday;//出生日期
    private String s_phone;//手机号
    private String s_email;//email
    private String s_address;//地址
    private String s_post;//邮编
    private String s_education;//学历
    private String s_college;//毕业院校
    private String s_major;//专业
    private Date s_graduate;//毕业时间
    private String s_intro;//简介
    private Date s_entrydate;//入职时间

    public Staff() {
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_username() {
        return s_username;
    }

    public void setS_username(String s_username) {
        this.s_username = s_username;
    }

    public String getS_pass() {
        return s_pass;
    }

    public void setS_pass(String s_pass) {
        this.s_pass = s_pass;
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

    public int getS_state() {
        return s_state;
    }

    public void setS_state(int s_state) {
        this.s_state = s_state;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_idcardno() {
        return s_idcardno;
    }

    public void setS_idcardno(String s_idcardno) {
        this.s_idcardno = s_idcardno;
    }

    public Date getS_birthday() {
        return s_birthday;
    }

    public void setS_birthday(Date s_birthday) {
        this.s_birthday = s_birthday;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_post() {
        return s_post;
    }

    public void setS_post(String s_post) {
        this.s_post = s_post;
    }

    public String getS_education() {
        return s_education;
    }

    public void setS_education(String s_education) {
        this.s_education = s_education;
    }

    public String getS_college() {
        return s_college;
    }

    public void setS_college(String s_college) {
        this.s_college = s_college;
    }

    public String getS_major() {
        return s_major;
    }

    public void setS_major(String s_major) {
        this.s_major = s_major;
    }

    public Date getS_graduate() {
        return s_graduate;
    }

    public void setS_graduate(Date s_graduate) {
        this.s_graduate = s_graduate;
    }

    public String getS_intro() {
        return s_intro;
    }

    public void setS_intro(String s_intro) {
        this.s_intro = s_intro;
    }

    public Date getS_entrydate() {
        return s_entrydate;
    }

    public void setS_entrydate(Date s_entrydate) {
        this.s_entrydate = s_entrydate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "s_id=" + s_id +
                ", s_username='" + s_username + '\'' +
                ", s_pass='" + s_pass + '\'' +
                ", department=" + department +
                ", job=" + job +
                ", s_state=" + s_state +
                ", s_name='" + s_name + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", s_idcardno='" + s_idcardno + '\'' +
                ", s_birthday=" + s_birthday +
                ", s_phone='" + s_phone + '\'' +
                ", s_email='" + s_email + '\'' +
                ", s_address='" + s_address + '\'' +
                ", s_post='" + s_post + '\'' +
                ", s_education='" + s_education + '\'' +
                ", s_college='" + s_college + '\'' +
                ", s_major='" + s_major + '\'' +
                ", s_graduate=" + s_graduate +
                ", s_intro='" + s_intro + '\'' +
                ", s_entrydate=" + s_entrydate +
                '}';
    }
}
