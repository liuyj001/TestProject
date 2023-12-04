package com.h3c.domain;

import lombok.Data;

@Data
public class Appsetting {
    private Integer id;
    private String qcType;
    private String deleteFlag;

    @Override
    public String toString() {
        return "Appsetting{" +
                "id=" + id +
                ", qcType='" + qcType + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                '}';
    }
}
