package com.gwy.service.impl;

import com.gwy.dao.DepartmentMapper;
import com.gwy.dao.JobMapper;
import com.gwy.service.DepartmentService;
import com.gwy.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Resource
    private DepartmentMapper departmentMapper;

}
