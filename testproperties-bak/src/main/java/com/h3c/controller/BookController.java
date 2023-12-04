package com.h3c.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/books", "/technology"})
public class BookController {
    @GetMapping("{id}")
    public String getBookById(@PathVariable Integer id) {
        System.out.println("当前有" + id + "本书");
        return "当前有" + id + "本书";
    }
}
