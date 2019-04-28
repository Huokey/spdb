package com.szxy.spdb.service.impl;

import com.szxy.spdb.dao.IFavoriteDao;
import com.szxy.spdb.dao.IRouteDao;
import com.szxy.spdb.po.Favorite;
import com.szxy.spdb.po.WebResult;
import com.szxy.spdb.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class FavoriteService implements IFavoriteService {
    @Autowired
    private IFavoriteDao favoriteDao;

    @Autowired
    private IRouteDao routeDao;

    @Override
    public WebResult findFavoriteByRid(int rid, int uid) {
        Favorite favorite = favoriteDao.selectByPrimaryKey(rid, uid);
        HashMap<String, String> map = new HashMap<>();
        int count = routeDao.findRouteCountByRid(rid);
        if (favorite == null) {
            //未收藏
            return WebResult.success("noFavorite", count);
        } else {
            //已收藏
            return WebResult.success("alreadyFavorite", count);
        }
    }

    @Override
    @Transactional
    public WebResult addFavoriteByRid(int uid, int rid) {
        //1.向tab_favorite添加一条数据
        Favorite favorite = new Favorite();
        favorite.setDate(new Date());
        favorite.setRid(rid);
        favorite.setUid(uid);
        favoriteDao.insert(favorite);
        //2.向tab_route的count加一
        routeDao.addRouteCountByRid(rid);
        //3.重新查询count
        int count = routeDao.findRouteCountByRid(rid);
        return WebResult.success("success", count);
    }
}