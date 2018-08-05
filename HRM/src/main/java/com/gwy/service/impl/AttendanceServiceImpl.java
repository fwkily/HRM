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

    @Override
    public double getOnMinutes(int s_id) {
        return attendanceMapper.getOnMinutes(s_id);
    }

    @Override
    public Attendance getAttendanceBySid(int s_id) {
        return attendanceMapper.getAttendanceBySid(s_id);
    }

    @Override
    public int off(int a_id) {
        return attendanceMapper.off(a_id);
    }

    @Override
    public double getOffMinutes(int s_id) {
        return attendanceMapper.getOffMinutes(s_id);
    }

    @Override
    public int updateAttendance(Attendance attendance) {
        return attendanceMapper.updateAttendance(attendance);
    }

    @Override
    public int getCountDayByDidJid(int d_id, int j_id) {
        return attendanceMapper.getCountDayByDidJid(d_id,j_id);
    }

    @Override
    public List<Attendance> queryCurrentPageStaffDayByDidJid(int d_id, int j_id, int begin, int end) {
        return attendanceMapper.queryCurrentPageStaffDayByDidJid(d_id,j_id,begin,end);
    }
}
