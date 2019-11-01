package com.ale.dao;

import com.ale.bean.Type;

import java.util.List;

public interface TypeDao {
    List<Type> findAll(int index, int limit);

    Type findById(long id);

    void save(Type type);

    void update(Type type);

    void deleteById(long id);

    int count();
}
