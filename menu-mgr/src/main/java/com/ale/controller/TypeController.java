package com.ale.controller;

import com.ale.bean.Type;
import com.ale.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeDao typeDao;

    @RequestMapping("/findAll/{index}/{limit}")
    public List<Type> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        return typeDao.findAll(index, limit);

    }

    @RequestMapping("/findById/{id}")
    public Type findById(@PathVariable("id") long id) {
        return typeDao.findById(id);
    }
}
