package com.gwy.service.impl;

import com.gwy.dao.InterviewMapper;
import com.gwy.model.Interview;
import com.gwy.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class InterviewServiceImpl implements InterviewService{
    @Resource
    private InterviewMapper interviewMapper;

    @Override
    public int addInterview(Interview interview) {
        return interviewMapper.addInterview(interview);
    }

    @Override
    public int getInterviewByUidIstate(int u_id, int i_state) {
        return interviewMapper.getInterviewByUidIstate( u_id,i_state);
    }

    @Override
    public List<Interview> queryCurrentInterviewByUidIstate(int u_id, int i_state, int begin, int end) {
        return interviewMapper.queryCurrentInterviewByUidIstate(u_id, i_state, begin, end);
    }

    @Override
    public Interview getInterviewByIid(int i_id) {
        return interviewMapper.getInterviewByIid(i_id);
    }

    @Override
    public int updateInterview(Interview interview) {
        return interviewMapper.updateInterview(interview);
    }

    @Override
    public int getInterviewByRiid(int ri_id,int i_state) {
        return interviewMapper.getInterviewByRiid(ri_id,i_state);
    }

    @Override
    public List<Interview> queryCurrentPageInterviewByRiid(int ri_id,int i_state, int begin, int end) {
        return interviewMapper.queryCurrentPageInterviewByRiid(ri_id,i_state,begin,end);
    }
}
