package com.h3c.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h3c.domain.Test1;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestDao extends BaseMapper<Test1> {

}

