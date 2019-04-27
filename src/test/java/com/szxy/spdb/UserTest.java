package com.szxy.spdb;

import com.szxy.spdb.dao.IRouteDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserTest {

    @Autowired
    private IRouteDao routeDao;

    @Test
    public void test(){
        int count = routeDao.findBrandRouteTotalCount(1, "圣象");
        System.out.println(count);
    }
}
