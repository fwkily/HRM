package com.gwy.service.impl;

import com.gwy.dao.Recruit_InformationMapper;
import com.gwy.service.Recruit_InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class Recruit_InformationServiceImpl implements Recruit_InformationService{
    @Resource
    private Recruit_InformationMapper recruit_informationMapper;

    @Override
    public int getRecruit_InformationByRiState(int i) {
        return recruit_informationMapper.getRecruit_InformationByRiState(i);
    }
}
