package com.gwy.service;


import com.gwy.model.Recruit_Information;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface Recruit_InformationService {
    int getRecruit_InformationByRiState(int i);

    List<Recruit_Information> queryCurrentPageRecruit_InformationByRiState(int state, int begin, int end);

    Recruit_Information getRecruit_InformationByRiid(int ri_id);

    int updateRecruit_Information(Recruit_Information recruitInformation);

    int deleteRecruit_Information(int ri_id);

    int addRecruit_Information(Recruit_Information recruit_information);
}
