package com.gwy.service.impl;

import com.gwy.dao.RapMapper;
import com.gwy.service.RapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class RapServiceImpl implements RapService{
    @Resource
    private RapMapper rapMapper;

}
