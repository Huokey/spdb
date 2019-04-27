package com.szxy.spdb.controller;

import com.szxy.spdb.po.WebResult;
import com.szxy.spdb.service.IBrandService;
import com.szxy.spdb.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private IRouteService routeService;

    //获取品牌列表
    @RequestMapping(value = "/findRouteByPage",method = RequestMethod.GET)
    public WebResult findRouteByPage(
            HttpServletRequest request,
            int cid,
            int currentPage,
            String searchValue) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        return routeService.findRouteByPage(cid,currentPage,searchValue);
    }
}