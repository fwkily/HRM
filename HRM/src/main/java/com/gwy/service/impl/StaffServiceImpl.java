package com.gwy.service.impl;

import com.gwy.dao.StaffMapper;
import com.gwy.model.Staff;
import com.gwy.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class StaffServiceImpl implements StaffService{
    @Resource
    private StaffMapper staffMapper;

    @Override
    public int getStaffByDidJidState(int d_id, int j_id, int s_state) {
        return staffMapper.getStaffByDidJidState(d_id,j_id,s_state);
    }

    @Override
    public List<Staff> queryCurrentPageStaffByDidJidState(int d_id, int j_id, int s_state, int begin, int end) {
        return staffMapper.queryCurrentPageStaffByDidJidState(d_id,j_id,s_state,begin,end);
    }

    @Override
    public List<Staff> getStaffsByDidJidState(int d_id, int j_id, int s_state) {
        return staffMapper.getStaffsByDidJidState(d_id,j_id,s_state);
    }

    @Override
    public int addStaff(Staff staff) {
        return staffMapper.addStaff(staff);
    }
}
