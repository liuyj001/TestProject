package com.h3c;

import com.h3c.domain.Clazz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Springboot17MongodbApplicationTests {

    @Resource
    MongoTemplate mongoTemplate;

    @Test
    void saveMongoDb() {
        Clazz clazz=new Clazz();
        clazz.setName("name");
        clazz.setInfo("info");
        clazz.setId(1);
        mongoTemplate.save(clazz);
    }

    void getMongoDb(){
        Criteria criteria = Criteria.where("name").is("name");
        Query query=new Query(criteria) ;

        List<Clazz> clazzes
                = mongoTemplate.find(query, Clazz.class);
        System.out.println(clazzes);
    }
}
