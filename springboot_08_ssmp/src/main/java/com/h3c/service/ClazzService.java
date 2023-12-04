package com.h3c.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.h3c.domain.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClazzService {
    Boolean save(Clazz clazz);

    Boolean update(Clazz clazz);

    Boolean delete(Integer id);

    Clazz getById(Integer id);

    List<Clazz> getAll();

    /**
     * @param page
     * @param wrapper
     * @return
     */
    IPage getByQuery(IPage<Clazz> page, @Param(Constants.WRAPPER) Wrapper<Clazz> wrapper);

//    void getByQuery(@Param(Constants.WRAPPER) Wrapper<Clazz> wrapper);
}
