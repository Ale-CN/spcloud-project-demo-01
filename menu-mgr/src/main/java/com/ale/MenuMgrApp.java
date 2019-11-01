package com.ale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ale.dao")
public class MenuMgrApp {
    public static void main(String[] args) {
        SpringApplication.run(MenuMgrApp.class, args);
    }
}
