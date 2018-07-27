package com.gwy.service.impl;

import com.gwy.dao.AdminMapper;
import com.gwy.model.Admin;
import com.gwy.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminByNamePass(Admin admin) {
        return adminMapper.getAdminByNamePass(admin);
    }
}
