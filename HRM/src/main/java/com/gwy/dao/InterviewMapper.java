package com.gwy.dao;


import com.gwy.model.Interview;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface InterviewMapper {

    int addInterview(Interview interview);

    int getInterviewByUidIstate(int u_id, int i_state);

    List<Interview> queryCurrentInterviewByUidIstate(int u_id, int i_state, int begin, int end);

    Interview getInterviewByIid(int i_id);

    int updateInterview(Interview interview);

    int getInterviewByRiid(int ri_id,int i_state);

    List<Interview> queryCurrentPageInterviewByRiid(int ri_id,int i_state, int begin, int end);
}
