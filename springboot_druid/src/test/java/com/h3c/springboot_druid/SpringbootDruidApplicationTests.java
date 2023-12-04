package com.h3c.springboot_druid;

import com.h3c.dao.TestDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDruidApplicationTests {

    @Autowired
    private TestDao testDao;


    @Test
    void contextLoads() {
        System.out.println(testDao.selectById((1)));
    }

}
