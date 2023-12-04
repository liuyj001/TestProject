package com.xxx.controller;

import com.alibaba.fastjson.JSON;
import com.xxx.common.AjaxResult;
import com.xxx.entity.User;
import com.xxx.jwt.JwtSupport;
import com.xxx.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lei
 * @version 1.0
 * @date 2020/11/28 16:27
 * @desc
 */
@RestController
public class TestController {
    private final LoginService loginService;
    private final JwtSupport jwtSupport;

    public TestController(JwtSupport jwtSupport, LoginService loginService) {
        this.jwtSupport = jwtSupport;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public AjaxResult<String> login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/test")
    public AjaxResult<String> test(String param, @RequestHeader("Authorization") String token) throws Exception {
        System.out.println(param);
        System.out.println(token.replaceAll("Bearer ",""));
        return AjaxResult.success("param:" + param + "      ====    userInfo" +
                JSON.toJSONString(jwtSupport.parseJwt(token.replaceAll("Bearer ",""))));
    }
}
