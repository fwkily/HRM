package com.gwy.service.impl;

import com.gwy.dao.PayMapper;
import com.gwy.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class PayServiceImpl implements PayService{
    @Resource
    private PayMapper payMapper;

}
