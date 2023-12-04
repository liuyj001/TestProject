package com.h3c.service;

import com.h3c.JiebaDemo2;

public class jiebaServiceImpl {
    public static void main(String[] args) {
        String path = jiebaServiceImpl.class.getClassLoader().getResource("dict-h3c.txt").getPath();
        System.out.println(path);
    }
}
