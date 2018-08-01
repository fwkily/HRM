package com.gwy.dao;


import com.gwy.model.Job;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface JobMapper {

    List<Job> getJob();

    List<Job> getJobByDid(int d_id);

    int deleteJobByDid(int d_id);

    int deleteJobByJid(int j_id);
}
