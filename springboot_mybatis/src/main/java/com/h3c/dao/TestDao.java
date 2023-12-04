package com.h3c.dao;

import com.h3c.domain.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestDao {
    @Select("select * from t_test where id=#{id}")
    public Test getById(Integer id);
}
