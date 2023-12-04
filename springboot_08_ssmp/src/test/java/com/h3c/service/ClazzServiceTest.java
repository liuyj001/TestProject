package com.h3c.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h3c.domain.Clazz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ClazzServiceTest {

    @Resource
    private IClazzService clazzService;

    @Test
    void testSelectById() {
        System.out.println(clazzService.getById(1));
    }

    @Test
    void testSelectByPage() {
        IPage page = new Page();
        page.setCurrent(1l);
        page.setSize(3l);
        clazzService.page(page, null);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testSelectByQuery() {
        LambdaQueryWrapper<Clazz> wrapper = new LambdaQueryWrapper<Clazz>();
        wrapper.like(Clazz::getName, "通信");
//        List<Clazz> clazzList = clazzService.getByQuery(wrapper);
//        System.out.println(clazzList.toString());
//        clazzService.getByQuery(wrapper);
    }
}
