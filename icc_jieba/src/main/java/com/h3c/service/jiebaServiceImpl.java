package com.h3c.service;

public class jiebaServiceImpl {
    public static void main(String[] args) {
        String path = jiebaServiceImpl.class.getClassLoader().getResource("dicts/dict-h3c.txt").getPath();
        System.out.println(path);
    }
}
