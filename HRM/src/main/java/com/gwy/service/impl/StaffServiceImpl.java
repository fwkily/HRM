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

    @Override
    public int updateStaff(Staff staff) {
        return staffMapper.updateStaff(staff);
    }

    @Override
    public int countStaffByDid(int d_id) {
        return staffMapper.countStaffByDid(d_id);
    }

    @Override
    public int countStaffByJid(int j_id) {
        return staffMapper.countStaffByJid(j_id);
    }

    @Override
    public Staff getStaffBySid(int s_id) {
        return staffMapper.getStaffBySid(s_id);
    }

    @Override
    public double getMonthsBySid(int s_id) {
        return staffMapper.getMonthsBySid(s_id);
    }

    @Override
    public int addCultivate(int s_id,int c_id) {
        return staffMapper.addCultivate(s_id,c_id);
    }

    @Override
    public List<Staff> getStaff() {
        return staffMapper.getStaff();
    }

    @Override
    public List<Staff> getStaffBySstate(int s_state) {
        return staffMapper.getStaffBySstate(s_state);
    }

    @Override
    public List<Staff> getStaffByDid(int d_id) {
        return staffMapper.getStaffByDid(d_id);
    }

    @Override
    public int deleteCultivate(int c_id) {
        return staffMapper.deleteCultivate(c_id);
    }

    @Override
    public Staff getStaffByNamePass(Staff staff) {
        return staffMapper.getStaffByNamePass(staff);
    }
}
