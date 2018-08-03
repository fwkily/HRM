package com.gwy.dao;


import com.gwy.model.Attendance;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface AttendanceMapper {

    int getCountDayBySid(int s_id);

    int addAttendance(Attendance attendance);

    int getCountMonthBySid(int s_id);

    List<Attendance> queryCountMonthBySid(int s_id, int begin, int end);
}
