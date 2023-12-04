package com;

import com.h3c.SpringbootJunitApplication;
import com.h3c.dao.BookDao;
import com.h3c.dao.impl.BookDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootJunitApplication.class)
class SpringbootJunitApplicationTests {

    @Autowired
    private BookDaoImpl bookDao;

    @Test
    void contextLoads() {
        bookDao.save();
        System.out.println("test……");
    }

}
