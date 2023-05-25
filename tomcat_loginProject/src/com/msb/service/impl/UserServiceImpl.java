package com.msb.service.impl;

import com.msb.dao.UserDao;
import com.msb.dao.impl.UserDaoImpl;
import com.msb.entity.User;
import com.msb.service.UserService;

/**
 * Created by 17081290 on 2021/3/10.
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }
}
