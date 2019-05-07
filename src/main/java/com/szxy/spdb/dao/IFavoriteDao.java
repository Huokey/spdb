package com.szxy.spdb.dao;

import com.szxy.spdb.po.Favorite;
import com.szxy.spdb.po.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IFavoriteDao {
    int deleteByPrimaryKey(@Param("rid") int rid,@Param("uid") int uid);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(@Param("rid") int rid,@Param("uid") int uid);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);

    int findFavoriteByUid(int uid);

    List<Route> findMyFavoriteRouteByPage(@Param("uid") int uid,@Param("start") int start,@Param("pageSize") int pageSize);
}