package com.h3c.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("{id}")
    public String getById(@PathVariable String id) {
        System.out.println("booksGetById " + id + " is running");
//        log.debug("debug");
//        log.info("info");
//        log.warn("warn");
//        log.error("error");
        return id;
    }
}
