package com.gwy.dao;


import com.gwy.model.Recruit;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface RecruitMapper {

    Recruit getRecruitByUserRe(int u_id, int re_id);

    int addRecruit(Recruit recruit);

    int getRecruitByRiidRstate(int ri_id, int r_state);

    List<Recruit> queryCurrentPageRecruitByRiidRstate(int ri_id, int r_state, int begin, int end);

    int updateRecruit(Recruit recruit);

    Recruit getRecruitByRid(int r_id);

    Recruit getRecruitByUidRiid(int u_id, int ri_id);
}
