package com.szxy.spdb.controller;

import com.alibaba.fastjson.JSON;
import com.szxy.spdb.po.User;
import com.szxy.spdb.po.WebResult;
import com.szxy.spdb.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    //获取当前的是登陆还是未登录状态
    @RequestMapping(value = "/findCurrentUser",method = RequestMethod.GET)
    public WebResult findCurrentUser(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        WebResult result = new WebResult();
        if (user == null) {
            result.setMessage("nologin");
        } else {
            result.setMessage(user.getUsername());
        }
        return result;
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public WebResult register(User user,String code) {
        String message = userService.register(user);
        WebResult result = new WebResult();
        result.setMessage(message);
        return result;
    }

    //校验手机号是否被注册过
    @RequestMapping(value = "/validatePhone",method = RequestMethod.GET)
    public WebResult validatePhone(String telephone){
        String message = userService.validatePhone(telephone);
        WebResult result = new WebResult();
        result.setMessage(message);
        return result;
    }

    //校验用户名是否被注册过
    @RequestMapping(value = "/validateUsername",method = RequestMethod.GET)
    public WebResult validateUsername(String username) {
        String message = userService.validateUsername(username);
        WebResult result = new WebResult();
        result.setMessage(message);
        return result;
    }
}