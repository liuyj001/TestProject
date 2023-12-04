package com.h3c.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h3c.domain.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestDao extends BaseMapper<Test> {

}
