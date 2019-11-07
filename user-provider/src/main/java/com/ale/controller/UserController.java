package com.ale.controller;

import com.ale.bean.User;
import com.ale.bean.UserVO;
import com.ale.dao.UserDao;
import com.ale.utils.VOutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id) {
        return userDao.findById(id);
    }

    @GetMapping("/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        int code = 0;
        String msg = "";
        int count = userDao.count();
        List<User> userList = userDao.findAll(index, limit);
        return VOutils.trans2VO(code, msg, count, userList);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable long id) {
        userDao.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userDao.update(user);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userDao.save(user);
    }
}
