package com.gwy.service.impl;

import com.gwy.dao.RapMapper;
import com.gwy.model.Rap;
import com.gwy.service.RapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class RapServiceImpl implements RapService{
    @Resource
    private RapMapper rapMapper;

    @Override
    public int addRap(Rap rap) {
        return rapMapper.addRap(rap);
    }

    @Override
    public int getCountMonthBySid(int s_id) {
        return rapMapper.getCountMonthBySid(s_id);
    }

    @Override
    public List<Rap> queryCountMonthBySid(int s_id, int begin, int end) {
        return rapMapper.queryCountMonthBySid(s_id,begin,end);
    }

    @Override
    public int getCountDayByDidJid(int d_id, int j_id) {
        return rapMapper.getCountDayByDidJid(d_id,j_id);
    }

    @Override
    public List<Rap> queryCurrentPageStaffDayByDidJid(int d_id, int j_id, int begin, int end) {
        return rapMapper.queryCurrentPageStaffDayByDidJid(d_id,j_id,begin,end);
    }
}
