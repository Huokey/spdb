package com.szxy.spdb.service;

import com.szxy.spdb.po.User;

public interface IUserService {

    String register(User user);

    String validatePhone(String telephone);

    String validateUsername(String username);
}