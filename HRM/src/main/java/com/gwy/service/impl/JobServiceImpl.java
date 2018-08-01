package com.gwy.service.impl;

import com.gwy.dao.JobMapper;
import com.gwy.model.Job;
import com.gwy.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class JobServiceImpl implements JobService{
    @Resource
    private JobMapper jobMapper;

    @Override
    public List<Job> getJob() {
        return jobMapper.getJob();
    }

    @Override
    public List<Job> getJobByDid(int d_id) {
        return jobMapper.getJobByDid(d_id);
    }

    @Override
    public int deleteJobByDid(int d_id) {
        return jobMapper.deleteJobByDid(d_id);
    }

    @Override
    public int deleteJobByJid(int j_id) {
        return jobMapper.deleteJobByJid(j_id);
    }

    @Override
    public int addJob(int d_id, String j_name,double j_salary) {
        return jobMapper.addJob(d_id,j_name,j_salary);
    }

    @Override
    public int updateJob(int j_id, String j_name,double j_salary) {
        return jobMapper.updateJob(j_id,j_name,j_salary);
    }
}
