package com.h3c.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.h3c.domain.Clazz;
import com.h3c.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private IClazzService clazzService;

    @GetMapping()
    public List<Clazz> getAll() {
        return clazzService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Clazz clazz) {
        return clazzService.save(clazz);
    }

    @PutMapping
    public Boolean update(@RequestBody Clazz clazz) {
        return clazzService.saveOrUpdate(clazz);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id) throws Exception {
        if (id.equals(1)) {
            throw new Exception();
        } else if (id.equals(2)) {
            Clazz clazz = null;
            System.out.println(clazz.getName());
        }
        return clazzService.removeById(id);
    }

    //    @RequestMapping(value = "/clazzs/{id}",method = RequestMethod.GET)
    @GetMapping("{id}")
    public Clazz getById(@PathVariable Integer id) {
        return clazzService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Clazz> getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return clazzService.getPage(currentPage, pageSize);
    }
}

