package com.ale.feign;

import com.ale.bean.Menu;
import com.ale.bean.MenuVO;
import com.ale.bean.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("menu-mgr")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")
    MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id") long id);

    @DeleteMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);

    @GetMapping("/type/findAll/{index}/{limit}")
    List<Type> findTypes(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @PostMapping("/menu/save")
    void save(@RequestBody Menu menu);

    @PutMapping("/menu/update")
    void update(@RequestBody Menu menu);

}
