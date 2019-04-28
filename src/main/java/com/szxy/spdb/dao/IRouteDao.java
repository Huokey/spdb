package com.szxy.spdb.dao;

import com.szxy.spdb.po.Brand;
import com.szxy.spdb.po.Route;
import com.szxy.spdb.po.Seller;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRouteDao {
    int deleteByPrimaryKey(Integer rid);

    int insert(Route record);

    int insertSelective(Route record);

    Route selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Route record);

    int updateByPrimaryKey(Route record);

    int findBrandRouteTotalCount(@Param("bid") int bid,@Param("searchValue") String searchValue);

    List<Route> findRouteByPage(@Param("bid") int bid, @Param("start")int start, @Param("pageSize")int pageSize,@Param("searchValue") String searchValue);

    Route findRouteDetailsByRid(int rid);

    Brand findBrandByRid(int rid);

    Seller findSellerByRid(int rid);

    int findRouteCountByRid(int rid);

    int addRouteCountByRid(int rid);

    List<Route> findPopularRoute();

    List<Route> findNewestRoute();

    List<Route> findDiscountRoute();
}