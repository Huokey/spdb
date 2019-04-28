package com.szxy.spdb.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.szxy.spdb.dao.IBrandDao;
import com.szxy.spdb.dao.IRouteDao;
import com.szxy.spdb.dao.IRouteImgDao;
import com.szxy.spdb.dao.ISellerDao;
import com.szxy.spdb.po.*;
import com.szxy.spdb.service.IBrandService;
import com.szxy.spdb.service.IRouteService;
import com.szxy.spdb.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

@Service
public class RouteService implements IRouteService {
    @Autowired
    private IRouteDao routeDao;

    @Autowired
    private IRouteImgDao routeImgDao;

    @Override
    public WebResult findRouteByPage(int cid, int currentPage, String searchValue) {
        PageBean pageBean = new PageBean();
        //1.当前页码数
        pageBean.setCurrentPage(currentPage);
        //2.上一页
        pageBean.setPrePage(currentPage - 1);
        //3.下一页
        pageBean.setNextPage(currentPage + 1);
        //4.数据总量
        int totalCount = routeDao.findBrandRouteTotalCount(cid, searchValue);
        pageBean.setTotalCount(totalCount);
        //5.每页显示的数量
        int pageSize = 6;
        pageBean.setPageSize(pageSize);
        //6.总页码数
        int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
        pageBean.setTotalPage(totalPage);
        //7.分页的页面需要的旅游线路
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findRouteByPage(cid, start, pageSize, searchValue);
        pageBean.setRouteList(list);
        return WebResult.success(pageBean);
    }

    @Override
    public WebResult findRouteDetailsByRid(int rid) {
        Route route = routeDao.findRouteDetailsByRid(rid);
        Brand brand = routeDao.findBrandByRid(rid);
        Seller seller = routeDao.findSellerByRid(rid);
        List<RouteImg> list = routeImgDao.findRouteImgsByRid(rid);
        route.setRouteImgList(list);
        route.setBrand(brand);
        route.setSeller(seller);
        return WebResult.success(route);
    }

    @Override
    public WebResult findChoiceRoute() {
        List<Route> popularList = routeDao.findPopularRoute();
        List<Route> newestList = routeDao.findNewestRoute();
        List<Route> discountList = routeDao.findDiscountRoute();

        HashMap<String, List<Route>> map = new HashMap<>();
        map.put("popularRoute",popularList);
        map.put("newestRoute",newestList);
        map.put("discountRoute",discountList);

        return WebResult.success(map);
    }
}