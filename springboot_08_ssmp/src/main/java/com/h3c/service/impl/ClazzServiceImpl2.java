package com.h3c.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h3c.dao.ClazzDao;
import com.h3c.domain.Clazz;
import com.h3c.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl2 implements ClazzService {
    @Autowired
    private ClazzDao clazzDao;

    @Override
    public Boolean save(Clazz clazz) {
        return clazzDao.insert(clazz) > 0;
    }

    @Override
    public Boolean update(Clazz clazz) {
        return clazzDao.updateById(clazz) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return clazzDao.deleteById(id) > 0;
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzDao.selectById(id);
    }

    @Override
    public List<Clazz> getAll() {
        return clazzDao.selectList(null);
    }

    @Override
    public Page<Clazz> getByQuery(IPage<Clazz> page, Wrapper<Clazz> wrapper) {
        return clazzDao.selectPage((Page<Clazz>) page, wrapper);
    }

//    @Override
    // public void getByQuery(Wrapper<Clazz> wrapper) {
//        clazzMapper.getByQuery(wrapper);
//    }


}
