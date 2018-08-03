package com.gwy.service;


import com.gwy.model.Cultivate;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface CultivateService {

    int getCultivateByCstate(int c_state);

    List<Cultivate> queryCurrentPageCultivateByCstate(int c_state, int begin, int end);

    int addCultivate(Cultivate cultivate);

    Cultivate getCultivateByCid(int c_id);

    int updateCultivate(Cultivate cultivate);

    double getMinutesByCid(int c_id);

    List<Cultivate> getCultivateBySid(int s_id,int begin,int end);

    int getCountBySid(int s_id);
}
