package com.gwy.service.impl;

import com.gwy.dao.DepartmentMapper;
import com.gwy.model.Department;
import com.gwy.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartment() {
        return departmentMapper.getDepartment();
    }

    @Override
    public int deleteDepartment(int d_id) {
        return departmentMapper.deleteDepartment(d_id);
    }
}
