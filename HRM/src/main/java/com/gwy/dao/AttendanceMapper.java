package com.gwy.dao;


import com.gwy.model.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface AttendanceMapper {

    int getCountDayBySid(int s_id);

    int addAttendance(Attendance attendance);

    int getCountMonthBySid(int s_id);

    List<Attendance> queryCountMonthBySid(int s_id, int begin, int end);

    double getOnMinutes(int s_id);

    Attendance getAttendanceBySid(int s_id);

    int off(int a_id);

    double getOffMinutes(int s_id);

    int updateAttendance(Attendance attendance);

    int getCountDayByDidJid(@Param("d_id")int d_id, @Param("j_id")int j_id);

    List<Attendance> queryCurrentPageStaffDayByDidJid(@Param("d_id")int d_id,@Param("j_id") int j_id,@Param("begin") int begin,@Param("end") int end);
}
