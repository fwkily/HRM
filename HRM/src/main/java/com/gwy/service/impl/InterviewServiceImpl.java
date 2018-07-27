package com.gwy.service.impl;

import com.gwy.dao.InterviewMapper;
import com.gwy.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class InterviewServiceImpl implements InterviewService{
    @Resource
    private InterviewMapper interviewMapper;

}
