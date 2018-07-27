package com.gwy.service;


import com.gwy.model.Recruit;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface RecruitService {

    Recruit getRecruitByUserRe(int u_id, int re_id);

    int addRecruit(Recruit recruit);
}
