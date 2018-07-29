package com.gwy.service;


import com.gwy.model.Recruit;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface RecruitService {

    Recruit getRecruitByUserRe(int u_id, int re_id);

    int addRecruit(Recruit recruit);

    int getRecruitByRiidRstate(int ri_id, int r_state);

    List<Recruit> queryCurrentPageRecruitByRiidRstate(int ri_id, int r_state, int begin, int end);

    int updateRecruit(Recruit recruit);
}
