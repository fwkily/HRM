package com.gwy.dao;


import com.gwy.model.Pay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface PayMapper {

    int getCountMonthPay();

    int getPayByDidJid(@Param("d_id")int d_id, @Param("j_id")int j_id);

    List<Pay> queryCurrentPagePayByDidJid(@Param("d_id")int d_id,@Param("j_id") int j_id,@Param("begin") int begin,@Param("end") int end);
}
