package com.szxy.spdb.dao;

import com.szxy.spdb.po.Brand;
import com.szxy.spdb.po.User;

import java.util.List;

public interface IUserDao {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByPhone(String telephone);

    User selectByUsername(String username);
}