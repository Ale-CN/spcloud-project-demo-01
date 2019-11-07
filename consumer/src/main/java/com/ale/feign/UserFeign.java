package com.ale.feign;

import com.ale.bean.User;
import com.ale.bean.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("user-provider")
public interface UserFeign {
    @GetMapping("/user/findById/{id}")
    User findById(@PathVariable("id") long id);

    @GetMapping("/user/findAll/{index}/{limit}")
    UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/user/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);

    @PutMapping("/user/update")
    void update(@RequestBody User user);

    @PostMapping("/user/save")
    void save(@RequestBody User user);
}
