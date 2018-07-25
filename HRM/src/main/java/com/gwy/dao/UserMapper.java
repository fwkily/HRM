package com.gwy.dao;

import com.gwy.model.User;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface UserMapper {
    User getUser(User user);

    User getUserByName(User user);

    void addUser(User user);
}
