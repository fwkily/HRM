package com.gwy.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/27/0027.
 */
//招聘表
public class Recruit implements Serializable{
    private int r_id;//ID
    private Recruit_Information recruitInformation;//招聘信息
    private Resume resume;//简历
    private int r_state;//状态

    public Recruit(Recruit_Information recruitInformation, Resume resume, int r_state) {
        this.recruitInformation = recruitInformation;
        this.resume = resume;
        this.r_state = r_state;
    }

    public Recruit() {
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public Recruit_Information getRecruitInformation() {
        return recruitInformation;
    }

    public void setRecruitInformation(Recruit_Information recruitInformation) {
        this.recruitInformation = recruitInformation;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public int getR_state() {
        return r_state;
    }

    public void setR_state(int r_state) {
        this.r_state = r_state;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "r_id=" + r_id +
                ", recruitInformation=" + recruitInformation +
                ", resume=" + resume +
                ", r_state=" + r_state +
                '}';
    }
}
