package com.h3c.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("project_budget")
public class ProjectBudget {
    @TableField("product_line")
    private String productLine;
    private String pdt;
    @TableField("project_name")
    private String projectName;
}
