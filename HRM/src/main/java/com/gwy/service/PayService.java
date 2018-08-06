package com.gwy.service;


import com.gwy.model.Pay;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface PayService {

    int getCountMonthPay();

    int getPayByDidJid(int d_id, int j_id);

    List<Pay> queryCurrentPagePayByDidJid(int d_id, int j_id, int begin, int end);

    int addPay(Pay pay);
}
