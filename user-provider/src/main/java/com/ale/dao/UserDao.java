package com.ale.dao;

import com.ale.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> findAll(@Param("index") int index, @Param("limit") int limit);

    User findById(long id);

    int count();

    void update(User user);

    void deleteById(long id);

    void save(User user);

    User findByUserName(String username);

}
