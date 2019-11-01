package com.ale.contoller;

import com.ale.bean.Menu;
import com.ale.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @RequestMapping("/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        return menuDao.findAll(index, limit);

    }

    @RequestMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id) {
        return menuDao.findById(id);
    }
}
