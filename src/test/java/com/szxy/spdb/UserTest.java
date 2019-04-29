package com.szxy.spdb;

import com.szxy.spdb.dao.IBrandDao;
import com.szxy.spdb.dao.IRouteDao;
import com.szxy.spdb.dao.IRouteImgDao;
import com.szxy.spdb.po.Brand;
import com.szxy.spdb.po.Route;
import com.szxy.spdb.po.RouteImg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserTest {

    @Autowired
    private IBrandDao brandDao;

    @Autowired
    private IRouteDao routeDao;

    @Autowired
    private IRouteImgDao routeImgDao;

    @Test
    public void test(){
        Route route = routeDao.findRouteDetailsByRid(1);
        System.out.println(route.getRouteIntroduce());
        System.out.println(route.getSourceId());
        System.out.println(route.getRname());
        Route key = routeDao.selectByPrimaryKey(1);
        System.out.println(key.getRouteIntroduce());
    }

    @Test
    public void test2(){
        List<RouteImg> list = routeImgDao.findRouteImgsByRid(1);
        System.out.println(list.size());
    }

    @Test
    public void test3(){
        List<Route> routeByPage = routeDao.findRouteByPage(1, 0, 1, null);
        System.out.println(routeByPage.get(0).getRouteIntroduce());
    }

    @Test
    public void test4(){
        List<Brand> list = brandDao.findAllBrands();
        System.out.println(list.get(0).getBname());
    }
}
