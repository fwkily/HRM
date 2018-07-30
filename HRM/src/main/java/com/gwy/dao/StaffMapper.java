package com.gwy.dao;


import com.gwy.model.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface StaffMapper {

    int getStaffByDidJidState(@Param("d_id") int d_id,@Param("j_id") int j_id,@Param("s_state") int s_state);

    List<Staff> queryCurrentPageStaffByDidJidState(int d_id, int j_id, int s_state, int begin, int end);

    List<Staff> getStaffsByDidJidState(@Param("d_id")int d_id,@Param("j_id") int j_id,@Param("s_state") int s_state);

    int addStaff(Staff staff);

    int updateStaff(Staff staff);
}
