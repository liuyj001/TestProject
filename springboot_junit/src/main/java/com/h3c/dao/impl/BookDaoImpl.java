package com.h3c.dao.impl;

import com.h3c.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("BookDao is running");
    }
}
