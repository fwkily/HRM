package com.gwy.service;

import com.gwy.model.User;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface UserService {
    User getUserByName(User user);

    void addUser(User user);
}
