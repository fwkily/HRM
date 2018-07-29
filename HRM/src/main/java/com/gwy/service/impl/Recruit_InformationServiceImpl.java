package com.gwy.service.impl;

import com.gwy.dao.Recruit_InformationMapper;
import com.gwy.model.Recruit_Information;
import com.gwy.service.Recruit_InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Recruit_Information> queryCurrentPageRecruit_InformationByRiState(int state, int begin, int end) {
        return recruit_informationMapper.queryCurrentPageRecruit_InformationByRiState(state,begin,end);
    }

    @Override
    public Recruit_Information getRecruit_InformationByRiid(int ri_id) {
        return recruit_informationMapper.getRecruit_InformationByRiid(ri_id);
    }

    @Override
    public int updateRecruit_Information(Recruit_Information recruitInformation) {
        return recruit_informationMapper.updateRecruit_Information(recruitInformation);
    }

    @Override
    public int deleteRecruit_Information(int ri_id) {
        return recruit_informationMapper.deleteRecruit_Information(ri_id);
    }

    @Override
    public int addRecruit_Information(Recruit_Information recruit_information) {
        return recruit_informationMapper.addRecruit_Information(recruit_information);
    }

}
