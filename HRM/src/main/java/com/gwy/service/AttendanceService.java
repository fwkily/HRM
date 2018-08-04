package com.gwy.service;


import com.gwy.model.Attendance;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface AttendanceService {

    int getCountDayBySid(int s_id);

    int addAttendance(Attendance attendance);

    int getCountMonthBySid(int s_id);

    List<Attendance> queryCountMonthBySid(int s_id, int begin, int end);

    double getOnMinutes(int s_id);

    Attendance getAttendanceBySid(int s_id);

    int off(int a_id);

    double getOffMinutes(int s_id);

    int updateAttendance(Attendance attendance);
}
