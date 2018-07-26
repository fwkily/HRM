package com.gwy.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by destiny on 2018/7/26/0026.
 */
//简历
public class Resume implements Serializable{
    private int reid;//简历ID
    private String resumename;//简历名
    private User user;//用户
    private String rename;//姓名
    private String resex;//性别
    private String reidcardno;//身份证号码
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date rebirthday;//出生时间
    private String rephone;//手机号码
    private String reemail;//email
    private String readdress;//地址
    private String repost;//邮政编码
    private String reeducation;//学历
    private String recollege;//毕业院校
    private String remajor;//专业
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date regraduate;//毕业时间
    private String reintro;//简介

    public Resume() {
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
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

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getResex() {
        return resex;
    }

    public void setResex(String resex) {
        this.resex = resex;
    }

    public String getReidcardno() {
        return reidcardno;
    }

    public void setReidcardno(String reidcardno) {
        this.reidcardno = reidcardno;
    }

    public Date getRebirthday() {
        return rebirthday;
    }

    public void setRebirthday(Date rebirthday) {
        this.rebirthday = rebirthday;
    }

    public String getRephone() {
        return rephone;
    }

    public void setRephone(String rephone) {
        this.rephone = rephone;
    }

    public String getReemail() {
        return reemail;
    }

    public void setReemail(String reemail) {
        this.reemail = reemail;
    }

    public String getReaddress() {
        return readdress;
    }

    public void setReaddress(String readdress) {
        this.readdress = readdress;
    }

    public String getRepost() {
        return repost;
    }

    public void setRepost(String repost) {
        this.repost = repost;
    }

    public String getReeducation() {
        return reeducation;
    }

    public void setReeducation(String reeducation) {
        this.reeducation = reeducation;
    }

    public String getRecollege() {
        return recollege;
    }

    public void setRecollege(String recollege) {
        this.recollege = recollege;
    }

    public String getRemajor() {
        return remajor;
    }

    public void setRemajor(String remajor) {
        this.remajor = remajor;
    }

    public Date getRegraduate() {
        return regraduate;
    }

    public void setRegraduate(Date regraduate) {
        this.regraduate = regraduate;
    }

    public String getReintro() {
        return reintro;
    }

    public void setReintro(String reintro) {
        this.reintro = reintro;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "reid=" + reid +
                ", resumename='" + resumename + '\'' +
                ", user=" + user +
                ", rename='" + rename + '\'' +
                ", resex='" + resex + '\'' +
                ", reidcardno='" + reidcardno + '\'' +
                ", rebirthday='" + rebirthday + '\'' +
                ", rephone='" + rephone + '\'' +
                ", reemail='" + reemail + '\'' +
                ", readdress='" + readdress + '\'' +
                ", repost='" + repost + '\'' +
                ", reeducation='" + reeducation + '\'' +
                ", recollege='" + recollege + '\'' +
                ", remajor='" + remajor + '\'' +
                ", regraduate='" + regraduate + '\'' +
                ", reintro='" + reintro + '\'' +
                '}';
    }
}
