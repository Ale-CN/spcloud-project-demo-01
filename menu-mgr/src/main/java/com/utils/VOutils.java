package com.utils;

import com.ale.bean.Menu;
import com.ale.bean.MenuVO;

import java.util.List;

public class VOutils {
    public static MenuVO trans2VO(int code, String msg, int count, List<Menu> menuList) {
        MenuVO menuVO = new MenuVO();
        menuVO.setCode(code);
        menuVO.setMsg(msg);
        menuVO.setCount(count);
        menuVO.setData(menuList);
        return menuVO;
    }

}
