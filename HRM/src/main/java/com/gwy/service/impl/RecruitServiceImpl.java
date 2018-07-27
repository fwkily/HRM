package com.gwy.service.impl;

import com.gwy.dao.RecruitMapper;
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

}
