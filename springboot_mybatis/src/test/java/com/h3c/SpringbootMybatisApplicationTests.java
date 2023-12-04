package com.h3c;

import com.h3c.dao.TestDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private TestDao testDao;


    @Test
    void contextLoads() {
        System.out.println(testDao.getById((1)));
    }

}
