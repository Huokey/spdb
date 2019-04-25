package com.szxy.spdb.service.impl;

import com.szxy.spdb.dao.UserDao;
import com.szxy.spdb.po.User;
import com.szxy.spdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceimpl  implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public User getUserByname(String name) {
        return userDao.getUserByname( name);
    }
    @Transactional
    public int addUser(String username, String password) {
        return userDao.addUser(username,password);
 
    }
}