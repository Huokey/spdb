package com.szxy.spdb.controller;

import com.alibaba.fastjson.JSON;
import com.szxy.spdb.dao.IRouteDao;
import com.szxy.spdb.po.User;
import com.szxy.spdb.po.WebResult;
import com.szxy.spdb.service.IFavoriteService;
import com.szxy.spdb.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private IFavoriteService favoriteService;

    @Autowired
    private IRouteDao routeDao;

    //验证收藏按钮
    @RequestMapping(value = "/findFavoriteByRid", method = RequestMethod.GET)
    public WebResult findFavoriteByRid(HttpServletRequest request, int rid) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            return favoriteService.findFavoriteByRid(rid, user.getUid());
        }else {
            int count = routeDao.findRouteCountByRid(rid);
            return WebResult.success("noLogin",count);
        }
    }

    //增加收藏记录
    @RequestMapping(value = "/addFavoriteByRid", method = RequestMethod.GET)
    public WebResult addFavoriteByRid(HttpServletRequest request,int rid){
        //1.检查用户是否登陆
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            //未登录
            return WebResult.fail("noLogin");
        } else {
            //已登陆
            int uid = user.getUid();
            return favoriteService.addFavoriteByRid(uid, rid);
        }
    }

    //我的收藏页面
    @RequestMapping(value = "/findMyFavoriteRouteByPage", method = RequestMethod.GET)
    public WebResult findMyFavoriteRouteByPage(HttpServletRequest request) throws IOException {
        //1.检查用户是否登陆
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return WebResult.fail("noLogin");
        }else {
            int uid = user.getUid();
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            return favoriteService.findMyFavoriteRouteByPage(currentPage,uid);
        }
    }
}