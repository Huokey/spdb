package com.szxy.spdb.dao;

import com.szxy.spdb.po.RouteImg;

public interface IRouteImgDao {
    int deleteByPrimaryKey(Integer rgid);

    int insert(RouteImg record);

    int insertSelective(RouteImg record);

    RouteImg selectByPrimaryKey(Integer rgid);

    int updateByPrimaryKeySelective(RouteImg record);

    int updateByPrimaryKey(RouteImg record);
}