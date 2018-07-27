package com.gwy.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/26/0026.
 */
//简历
public class Resume implements Serializable{
    private int re_id;//简历ID
    private String resumename;//简历名
    private User user;//用户
    private String re_name;//姓名
    private String re_sex;//性别
    private String re_idcardno;//身份证号码
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date re_birthday;//出生时间
    private String re_phone;//手机号码
    private String re_email;//email
    private String re_address;//地址
    private String re_post;//邮政编码
    private String re_education;//学历
    private String re_college;//毕业院校
    private String re_major;//专业
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date re_graduate;//毕业时间
    private String re_intro;//简介

    public Resume() {
    }

    public Resume(int re_id) {
        this.re_id = re_id;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public String getResumename() {
        return resumename;
    }

    public void setResumename(String resumename) {
        this.resumename = resumename;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRe_name() {
        return re_name;
    }

    public void setRe_name(String re_name) {
        this.re_name = re_name;
    }

    public String getRe_sex() {
        return re_sex;
    }

    public void setRe_sex(String re_sex) {
        this.re_sex = re_sex;
    }

    public String getRe_idcardno() {
        return re_idcardno;
    }

    public void setRe_idcardno(String re_idcardno) {
        this.re_idcardno = re_idcardno;
    }

    public Date getRe_birthday() {
        return re_birthday;
    }

    public void setRe_birthday(Date re_birthday) {
        this.re_birthday = re_birthday;
    }

    public String getRe_phone() {
        return re_phone;
    }

    public void setRe_phone(String re_phone) {
        this.re_phone = re_phone;
    }

    public String getRe_email() {
        return re_email;
    }

    public void setRe_email(String re_email) {
        this.re_email = re_email;
    }

    public String getRe_address() {
        return re_address;
    }

    public void setRe_address(String re_address) {
        this.re_address = re_address;
    }

    public String getRe_post() {
        return re_post;
    }

    public void setRe_post(String re_post) {
        this.re_post = re_post;
    }

    public String getRe_education() {
        return re_education;
    }

    public void setRe_education(String re_education) {
        this.re_education = re_education;
    }

    public String getRe_college() {
        return re_college;
    }

    public void setRe_college(String re_college) {
        this.re_college = re_college;
    }

    public String getRe_major() {
        return re_major;
    }

    public void setRe_major(String re_major) {
        this.re_major = re_major;
    }

    public Date getRe_graduate() {
        return re_graduate;
    }

    public void setRe_graduate(Date re_graduate) {
        this.re_graduate = re_graduate;
    }

    public String getRe_intro() {
        return re_intro;
    }

    public void setRe_intro(String re_intro) {
        this.re_intro = re_intro;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "re_id=" + re_id +
                ", resumename='" + resumename + '\'' +
                ", user=" + user +
                ", re_name='" + re_name + '\'' +
                ", re_sex='" + re_sex + '\'' +
                ", re_idcardno='" + re_idcardno + '\'' +
                ", re_birthday=" + re_birthday +
                ", re_phone='" + re_phone + '\'' +
                ", re_email='" + re_email + '\'' +
                ", re_address='" + re_address + '\'' +
                ", re_post='" + re_post + '\'' +
                ", re_education='" + re_education + '\'' +
                ", re_college='" + re_college + '\'' +
                ", re_major='" + re_major + '\'' +
                ", re_graduate=" + re_graduate +
                ", re_intro='" + re_intro + '\'' +
                '}';
    }
}
