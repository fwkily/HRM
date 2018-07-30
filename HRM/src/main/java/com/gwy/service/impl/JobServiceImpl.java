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
}
