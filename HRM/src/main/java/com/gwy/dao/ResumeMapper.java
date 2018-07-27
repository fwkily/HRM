package com.gwy.dao;


import com.gwy.model.Resume;
import com.gwy.model.User;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface ResumeMapper {

    int getResumeByUser(User user);

    List<Resume> queryCurrentResumeByUser(int uid, int begin, int end);

    int addResume(Resume resume);

    Resume getResumeByReid(int reid);

    int updateResume(Resume resume);

    int deleteResume(Resume resume);

    List<Resume> getResumesByUser(User user);
}
