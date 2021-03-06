package com.gwy.service;


import com.gwy.model.Job;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface JobService {
    List<Job> getJob();

    List<Job> getJobByDid(int d_id);

    int deleteJobByDid(int d_id);

    int deleteJobByJid(int j_id);

    int addJob(int d_id, String j_name,double j_salary);

    int updateJob(int j_id, String j_name,double j_salary);
}
