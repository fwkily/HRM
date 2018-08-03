package com.gwy.service.impl;

import com.gwy.dao.AttendanceMapper;
import com.gwy.model.Attendance;
import com.gwy.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Resource
    private AttendanceMapper attendanceMapper;

    @Override
    public int getCountDayBySid(int s_id) {
        return attendanceMapper.getCountDayBySid(s_id);
    }

    @Override
    public int addAttendance(Attendance attendance) {
        return attendanceMapper.addAttendance(attendance);
    }

    @Override
    public int getCountMonthBySid(int s_id) {
        return attendanceMapper.getCountMonthBySid(s_id);
    }

    @Override
    public List<Attendance> queryCountMonthBySid(int s_id, int begin, int end) {
        return attendanceMapper.queryCountMonthBySid(s_id,begin,end);
    }
}
