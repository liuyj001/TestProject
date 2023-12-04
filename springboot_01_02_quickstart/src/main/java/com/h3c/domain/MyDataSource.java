package com.h3c.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.datasource")
@Data
public class MyDataSource {
    private String url;
    private String driver;
    private String username;
    private String password;
}
