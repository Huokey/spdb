package com.szxy.spdb.dao;

import com.szxy.spdb.po.Favorite;
import org.apache.ibatis.annotations.Param;

public interface IFavoriteDao {
    int deleteByPrimaryKey(@Param("rid") int rid,@Param("uid") int uid);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(@Param("rid") int rid,@Param("uid") int uid);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}