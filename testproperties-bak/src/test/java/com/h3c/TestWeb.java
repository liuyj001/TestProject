package com.h3c;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.util.Assert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟MVC调用
@AutoConfigureMockMvc
public class TestWeb {
    @Test
        //注入虚拟MVC调用
    void testGetById(@Autowired MockMvc mvc) throws Exception {
        //写明调用地址url
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books/17");
        //发起调用
        ResultActions actions = mvc.perform(requestBuilder);

        // 定义本次的预期结果状态
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher resultMatcher=  status.isOk();

        actions.andExpect(resultMatcher);

    }
}
