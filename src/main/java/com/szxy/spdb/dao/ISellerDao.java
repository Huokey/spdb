package com.szxy.spdb.dao;

import com.szxy.spdb.po.Seller;

public interface ISellerDao {
    int deleteByPrimaryKey(Integer sid);

    int insert(Seller record);

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
}