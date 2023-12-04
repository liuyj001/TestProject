package com.h3c.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h3c.domain.ProjectBudget;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectBudgetDao extends BaseMapper<ProjectBudget> {
}
