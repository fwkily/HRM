package com.gwy.service.impl;

import com.gwy.dao.CultivateMapper;
import com.gwy.model.Cultivate;
import com.gwy.service.CultivateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class CultivateServiceImpl implements CultivateService{
    @Resource
    private CultivateMapper cultivateMapper;

    @Override
    public int getCultivateByCstate(int c_state) {
        return cultivateMapper.getCultivateByCstate(c_state);
    }

    @Override
    public List<Cultivate> queryCurrentPageCultivateByCstate(int c_state, int begin, int end) {
        return cultivateMapper.queryCurrentPageCultivateByCstate(c_state,begin,end);
    }

    @Override
    public int addCultivate(Cultivate cultivate) {
        return cultivateMapper.addCucltivate(cultivate);
    }

    @Override
    public Cultivate getCultivateByCid(int c_id) {
        return cultivateMapper.getCultivateByCid(c_id);
    }

    @Override
    public int updateCultivate(Cultivate cultivate) {
        return cultivateMapper.updateCultivate(cultivate);
    }

    @Override
    public double getMinutesByCid(int c_id) {
        return cultivateMapper.getMinutesByCid(c_id);
    }

    @Override
    public List<Cultivate> getCultivateBySid(int s_id,int begin,int end) {
        return cultivateMapper.getCultivateBySid(s_id,begin,end);
    }

    @Override
    public int getCountBySid(int s_id) {
        return cultivateMapper.getCountBySid(s_id);
    }
}
