package com.h3c;

import com.h3c.dao.TestDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private TestDao testDao;

    @Test
    void contextLoads() {
        System.out.println(testDao.selectById(2));
    }

    @Test
    void getAll() {
        System.out.println(testDao.selectList(null));
    }
}
