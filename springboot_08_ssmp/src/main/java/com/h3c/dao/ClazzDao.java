package com.h3c.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h3c.domain.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ClazzDao extends BaseMapper<Clazz> {
    @Select("select * from s_clazz where id= #{id}")
    Clazz getById(Integer id);

//    void getByQuery( Wrapper<Clazz> wrapper) ;
//
  void getALl() ;

}
