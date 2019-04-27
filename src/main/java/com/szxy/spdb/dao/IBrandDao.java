package com.szxy.spdb.dao;

import com.szxy.spdb.po.Brand;

import java.util.List;

public interface IBrandDao {
    int deleteByPrimaryKey(Integer bid);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> findAllBrands();
}