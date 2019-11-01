package com.ale.dao;

import com.ale.bean.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> findAll(int index, int limit);

    Menu findById(long id);

    int count();

    void save(Menu menu);

    void update(Menu menu);

    void deleteById(long id);
}
