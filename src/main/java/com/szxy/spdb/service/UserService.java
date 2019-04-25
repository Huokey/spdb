package com.szxy.spdb.service;

import com.szxy.spdb.po.User;

public interface UserService {
    public User getUserByname(String name);
    public int addUser(String username,String password );
}