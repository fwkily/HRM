package com.gwy.dao;


import com.gwy.model.Recruit;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface RecruitMapper {

    Recruit getRecruitByUserRe(int u_id, int re_id);

    int addRecruit(Recruit recruit);
}
