package com.szxy.spdb.controller;

import com.szxy.spdb.po.User;
import com.szxy.spdb.po.WebResult;
import com.szxy.spdb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //获取当前的是登陆还是未登录状态
    @RequestMapping(value = "/findCurrentUser",method = RequestMethod.GET)
    public WebResult findCurrentUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return WebResult.fail("nologin");
        } else {
            return WebResult.success(user.getUsername());
        }
    }

    //登出
    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    public void loginOut(HttpServletRequest request){
        request.getSession().invalidate();
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public WebResult register(User user,String code) {
        WebResult result = userService.register(user);
        return result;
    }

    //校验手机号是否被注册过
    @RequestMapping(value = "/validatePhone",method = RequestMethod.GET)
    public WebResult validatePhone(String telephone){
        WebResult result = userService.validatePhone(telephone);
        return result;
    }

    //校验用户名是否被注册过
    @RequestMapping(value = "/validateUsername",method = RequestMethod.GET)
    public WebResult validateUsername(String username) {
        WebResult result = userService.validateUsername(username);
        return result;
    }

    //登陆
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public WebResult login(String telephone,String password,HttpServletRequest request) {
        WebResult result = userService.login(telephone,password,request);
        return result;
    }
}