package com.gwy.dao;


import com.gwy.model.Cultivate;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface CultivateMapper {

    int getCultivateByCstate(int c_state);

    List<Cultivate> queryCurrentPageCultivateByCstate(int c_state, int begin, int end);

    int addCucltivate(Cultivate cultivate);

    Cultivate getCultivateByCid(int c_id);

    int updateCultivate(Cultivate cultivate);

    double getMinutesByCid(int c_id);
}
