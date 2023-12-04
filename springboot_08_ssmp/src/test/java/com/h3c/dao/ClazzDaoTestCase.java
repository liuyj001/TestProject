package com.h3c.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h3c.domain.Clazz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class ClazzDaoTestCase {
    @Autowired
    private ClazzDao clazzDao;

    @Test
    void testGetById() {
        System.out.println(clazzDao.getById(1));
    }

    @Test
    void testSelectById() {
        System.out.println(clazzDao.selectById(1));
    }

    @Test
    void testInsert() {
        Clazz clazz = new Clazz();
        clazz.setInfo("通信一班");
        clazz.setName("通信专业33");
        clazzDao.insert(clazz);
    }

    @Test
    void deletebyId() {
        clazzDao.deleteById(7);
    }

    @Test
    void testGetByPage() {
        IPage page = new Page();
        page.setCurrent(1l);
        page.setSize(3l);
        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.like("name","通信");
        clazzDao.selectPage(page, wrapper);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetByPage2() {
        String val = null;
        LambdaQueryWrapper<Clazz> wrapper = new LambdaQueryWrapper();
        wrapper.like(val != null, Clazz::getName, val);
        clazzDao.selectList(wrapper);
    }

    @Test
    void testGetByPage3() {
        String val = "通信";
        LambdaQueryWrapper<Clazz> wrapper = new LambdaQueryWrapper();
        wrapper.like(val != null, Clazz::getName, val);
        System.out.println(wrapper.getSqlSegment());
        List<Map<String, Object>> maps = clazzDao.selectMaps(wrapper);
        System.out.println("===========================");
        for (Map<String, Object> map : maps) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println("Key: " + key + ", Value: " + value);
            }
        }
        System.out.println("----------------------------");
        System.out.println(maps.toString());
    }

 /*   @Test
    void testSelectByQuery(){
        LambdaQueryWrapper<Clazz> wrapper=new LambdaQueryWrapper<Clazz>();
        wrapper.like(Clazz::getName,"通信");
        clazzDao.getALl();
       *//* List<Clazz> clazzList = clazzMapper.getByQuery(null);
        System.out.println(clazzList.toString());*//*
    }*/
}
