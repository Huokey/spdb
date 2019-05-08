package com.szxy.spdb.service.impl;

import com.szxy.spdb.dao.IUserDao;
import com.szxy.spdb.po.User;
import com.szxy.spdb.po.WebResult;
import com.szxy.spdb.service.IUserService;
import com.szxy.spdb.utils.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public WebResult register(User user, String check) {
        if (StringUtils.isEmpty(user.getTelephone())) {
            return WebResult.fail("手机号不能为空");
        } else if (StringUtils.isEmpty(user.getPassword())) {
            return WebResult.fail("密码不能为空");
        } else if (StringUtils.isEmpty(user.getUsername())) {
            return WebResult.fail("用户名不能为空");
        } else if (!check.toUpperCase().equals("JGMXJ")) {
            return WebResult.fail("验证码错误");
        } else {
            User phone = userDao.selectByPhone(user.getTelephone());
            User username = userDao.selectByUsername(user.getUsername());
            if (phone == null && username == null) {
                try {
                    user.setPassword((Md5Util.encodeByMd5(user.getPassword())));
                    int result = userDao.insert(user);
                    if (result != 0) {
                        return WebResult.success();
                    } else {
                        return WebResult.fail("注册失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return WebResult.fail("服务器正忙");
                }
            }
            return WebResult.fail("用户名或手机号已注册");
        }
    }

    @Override
    public WebResult validatePhone(String telephone) {
        User user = userDao.selectByPhone(telephone);
        if (user == null) {
            return WebResult.fail();
        } else {
            return WebResult.success();
        }
    }

    @Override
    public WebResult validateUsername(String username) {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            return WebResult.fail();
        } else {
            return WebResult.success();
        }
    }

    @Override
    public WebResult login(String telephone, String password, HttpServletRequest request) {
        User user = userDao.selectByPhone(telephone);
        if (user==null){
            return WebResult.fail("phoneError");
        }
        try {
            String pwd = Md5Util.encodeByMd5(password);
            if (pwd.equals(user.getPassword())){
                request.getSession().setAttribute("user",user);
                return WebResult.success("success");
            }else {
                return WebResult.fail("passwordError");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return WebResult.fail("服务器正忙");
        }

    }
}