package com.szxy.spdb.dao;

import com.szxy.spdb.po.User;

public interface UserDao {

    public User getUserByname(String name);

    public int addUser(String username,String password);
}
