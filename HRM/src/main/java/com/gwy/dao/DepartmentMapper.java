package com.gwy.dao;


import com.gwy.model.Department;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface DepartmentMapper {

    List<Department> getDepartment();

    int deleteDepartment(int d_id);

    int addDepartment(String d_name);

    int updateDepartment(int d_id, String d_name);
}
