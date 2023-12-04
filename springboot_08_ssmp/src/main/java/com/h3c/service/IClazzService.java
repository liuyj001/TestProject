package com.h3c.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.h3c.domain.Clazz;
import org.apache.ibatis.annotations.Mapper;

//@Service
@Mapper
public interface IClazzService extends IService<Clazz> {
    IPage<Clazz> getPage(Integer currentPage, Integer pageSize);
}
