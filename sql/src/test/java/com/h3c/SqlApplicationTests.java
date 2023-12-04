package com.h3c;

import com.h3c.dao.ProjectBudgetDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlApplicationTests {
    @Autowired
ProjectBudgetDao projectBudgetDao;

    @Test
    void contextLoads() {
    }

    @Test
    void getAllData(){

        System.out.println(projectBudgetDao.selectList(null));
    }

}
