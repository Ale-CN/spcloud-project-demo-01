package com.ale.controller;

import com.ale.bean.Menu;
import com.ale.bean.MenuVO;
import com.ale.dao.MenuDao;
import com.utils.VOutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @RequestMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        int code = 0;
        String msg = "";
        int count = menuDao.count();
        return VOutils.trans2VO(code, msg, count, menuDao.findAll(index, limit));
    }

    @RequestMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id) {
        return menuDao.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        menuDao.deleteById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu) {
        menuDao.save(menu);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu) {
        menuDao.update(menu);
    }
}
