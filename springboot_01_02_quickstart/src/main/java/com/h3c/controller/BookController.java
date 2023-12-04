package com.h3c.controller;

import com.h3c.domain.MyDataSource;
import com.h3c.domain.MyLikes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    //TODO研究下如何注入数组
    @Autowired
    MyLikes myLikes;

    @Value("${server.port}")
    private String port;

    @Value("${likes[0]}")
    private String likes;




    @Autowired
    private Environment environment;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById() {
        System.out.println("springboot is running^2");
        System.out.println(port);
        System.out.println(likes);
//        System.out.println(myLikes.getLikes());

        System.out.println(environment.getProperty("server.port"));

        System.out.println("---------------------------------");
        System.out.println(myDataSource.toString());
        return "springboot is running……2";

    }

}
