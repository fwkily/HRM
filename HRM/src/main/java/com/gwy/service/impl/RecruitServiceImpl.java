package com.gwy.service.impl;

import com.gwy.dao.RecruitMapper;
import com.gwy.model.Recruit;
import com.gwy.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class RecruitServiceImpl implements RecruitService{
    @Resource
    private RecruitMapper recruitMapper;

    @Override
    public Recruit getRecruitByUserRe(int u_id, int re_id) {
        return recruitMapper.getRecruitByUserRe(u_id,re_id);
    }

    @Override
    public int addRecruit(Recruit recruit) {
        return recruitMapper.addRecruit(recruit);
    }
}
