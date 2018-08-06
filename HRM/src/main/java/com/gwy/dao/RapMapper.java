package com.gwy.dao;


import com.gwy.model.Rap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface RapMapper {

    int addRap(Rap rap);

    int getCountMonthBySid(int s_id);

    List<Rap> queryCountMonthBySid(int s_id, int begin, int end);

    int getCountDayByDidJid(@Param("d_id")int d_id, @Param("j_id")int j_id);

    List<Rap> queryCurrentPageStaffDayByDidJid(@Param("d_id")int d_id,@Param("j_id") int j_id,@Param("begin") int begin,@Param("end") int end);

    List<Rap> getRapLastMonthBySid(int s_id);
}
