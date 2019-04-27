package com.szxy.spdb.controller;

import com.szxy.spdb.po.WebResult;
import com.szxy.spdb.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService categoryService;

    //获取品牌列表
    @RequestMapping(value = "/findAllBrands",method = RequestMethod.GET)
    public WebResult findAllBrands(){
        //从数据库获取category数据
        return categoryService.findAllBrands();
    }
}