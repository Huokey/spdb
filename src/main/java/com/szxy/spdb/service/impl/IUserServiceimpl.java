package com.szxy.spdb.service.impl;

import com.szxy.spdb.dao.IUserDao;
import com.szxy.spdb.po.User;
import com.szxy.spdb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceimpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public String register(User user) {
        int result = userDao.insert(user);
        if (result!=0){
            return "yes";
        }else {
            return  "注册失败";
        }
    }

    @Override
    public String validatePhone(String telephone) {
        User user = userDao.selectByPhone(telephone);
        if (user == null) {
            return "no";
        } else {
            return "yes";
        }
    }

    @Override
    public String validateUsername(String username) {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            return "no";
        } else {
            return "yes";
        }
    }
}