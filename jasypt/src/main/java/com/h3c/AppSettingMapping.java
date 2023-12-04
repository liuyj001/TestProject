package com.h3c;

import com.h3c.domain.Appsetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AppSettingMapping  {
    @Select("select id,qc_type as qctype,delete_flag as deleteFlag from appsetting a ")
    List<Appsetting> getAll();
}
