package com.gwy.service;


import com.gwy.model.Staff;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface StaffService {

    int getStaffByDidJidState(int d_id, int j_id, int s_state);

    List<Staff> queryCurrentPageStaffByDidJidState(int d_id, int j_id, int s_state, int begin, int end);
}
