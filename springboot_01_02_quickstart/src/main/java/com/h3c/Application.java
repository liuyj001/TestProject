package com.h3c;

import com.h3c.controller.BookController;
import com.h3c.controller.User;
import com.h3c.domain.MyLikes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext cxt = SpringApplication.run(Application.class, args);
        BookController bean = cxt.getBean(BookController.class);
        System.out.println(bean);
        User user = cxt.getBean(User.class);
        System.out.println(user);
        MyLikes likes = cxt.getBean(MyLikes.class);
        System.out.println(likes);
    }

}
