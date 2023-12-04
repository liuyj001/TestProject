package com.h3c.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h3c.dao.ClazzDao;
import com.h3c.domain.Clazz;
import com.h3c.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzDao, Clazz> implements IClazzService {

    @Autowired
    private ClazzDao clazzDao;

    @Override
    public IPage<Clazz> getPage(Integer currentPage, Integer pageSize) {
        IPage<Clazz> page = new Page(currentPage, pageSize);
        return clazzDao.selectPage(page, null);
    }
}
