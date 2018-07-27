package com.gwy.service.impl;

import com.gwy.dao.CultivateMapper;
import com.gwy.service.CultivateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class CultivateServiceImpl implements CultivateService{
    @Resource
    private CultivateMapper cultivateMapper;

}
