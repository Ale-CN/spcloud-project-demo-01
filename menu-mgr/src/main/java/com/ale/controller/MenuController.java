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
        int code = 200;
        String msg = "";
        int count = menuDao.count();
        return VOutils.trans2VO(code, msg, count, menuDao.findAll(index, limit));
    }

    @RequestMapping("/findById/{id}")
    public MenuVO findById(@PathVariable("id") long id) {
        int code = 200;
        String msg = "";
        int count = 1;
        List<Menu> menuList = new ArrayList<>();
        menuList.add(menuDao.findById(id));
        return VOutils.trans2VO(code, msg, count, menuList);
    }
}
