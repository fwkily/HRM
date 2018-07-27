package com.gwy.service.impl;

import com.gwy.dao.AttendanceMapper;
import com.gwy.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Resource
    private AttendanceMapper attendanceMapper;

}
