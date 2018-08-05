package com.gwy.service;


import com.gwy.model.Rap;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface RapService {

    int addRap(Rap rap);

    int getCountMonthBySid(int s_id);

    List<Rap> queryCountMonthBySid(int s_id, int begin, int end);

    int getCountDayByDidJid(int d_id, int j_id);

    List<Rap> queryCurrentPageStaffDayByDidJid(int d_id, int j_id, int begin, int end);
}
