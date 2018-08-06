package com.gwy.service.impl;

import com.gwy.dao.PayMapper;
import com.gwy.model.Pay;
import com.gwy.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class PayServiceImpl implements PayService{
    @Resource
    private PayMapper payMapper;

    @Override
    public int getCountMonthPay() {
        return payMapper.getCountMonthPay();
    }

    @Override
    public int getPayByDidJid(int d_id, int j_id) {
        return payMapper.getPayByDidJid(d_id,j_id);
    }

    @Override
    public List<Pay> queryCurrentPagePayByDidJid(int d_id, int j_id, int begin, int end) {
        return payMapper.queryCurrentPagePayByDidJid(d_id,j_id,begin,end);
    }

    @Override
    public int addPay(Pay pay) {
        return payMapper.addPay(pay);
    }
}
