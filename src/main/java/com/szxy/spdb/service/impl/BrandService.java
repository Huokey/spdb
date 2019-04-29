package com.szxy.spdb.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.szxy.spdb.dao.IBrandDao;
import com.szxy.spdb.dao.IUserDao;
import com.szxy.spdb.po.Brand;
import com.szxy.spdb.po.WebResult;
import com.szxy.spdb.service.IBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandDao brandDao;

    @Override
    public WebResult findAllBrands() {
        //Jedis jedis = new Jedis();
        //String json = jedis.get("brands");
        //if (StringUtils.isEmpty(json)){
            //从数据库中获取数据
            List<Brand> list = brandDao.findAllBrands();
            //json = JSON.toJSONString(list);
            //jedis.set("brands",json);
            return WebResult.success(list);
        //}else {
            //从jedis中获取数据
         //   List<Brand> value = JSONObject.parseArray(json, Brand.class);
           // return WebResult.success("yes",value);
       // }
    }
}