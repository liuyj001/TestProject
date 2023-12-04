package com.h3c;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"test.prop=testvalue1"}, args = {"--test.prop=testValue2"})
public class TestApplication {
    @Value("${test.prop}")
    private String msg;

    @Test
    void testGetProperties() {
        System.out.println(msg);
    }

}
