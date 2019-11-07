package com.ale.controller;

import com.ale.bean.Menu;
import com.ale.bean.MenuVO;
import com.ale.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit < 0 ? 0 : (page - 1) * limit;
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        menuFeign.deleteById(id);
        System.out.println("deleteById = " + id);
        return "redirect:/menu/redirect/index";
    }

    @RequestMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @GetMapping("/findTypes/{page}/{limit}")
    public ModelAndView findTypes(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        int index = (page - 1) * limit < 0 ? 0 : (page - 1) * limit;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list", menuFeign.findTypes(index, limit));
        return modelAndView;
    }

    @GetMapping("/findTypes")
    public ModelAndView findTypes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list", menuFeign.findTypes(0, 999));
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Menu menu) {
        menuFeign.save(menu);
        return "redirect:/menu/redirect/index";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu", menuFeign.findById(id));
        modelAndView.addObject("list",menuFeign.findTypes(0,999));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Menu menu) {
        menuFeign.update(menu);
        return "redirect:/menu/redirect/index";
    }


}
