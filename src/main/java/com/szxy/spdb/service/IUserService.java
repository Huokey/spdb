package com.szxy.spdb.service;

import com.szxy.spdb.po.User;
import com.szxy.spdb.po.WebResult;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {

    WebResult register(User user, String check);

    WebResult validatePhone(String telephone);

    WebResult validateUsername(String username);

    WebResult login(String telephone, String password, HttpServletRequest request);
}