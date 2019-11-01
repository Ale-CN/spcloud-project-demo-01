package com.ale.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cfg")
public class TestConfigController {

    @Value("${server.port}")
    private String port;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @RequestMapping("/info")
    public String info() {
        return "port = " + this.port + "\\n url = " + this.url + "\\n username = " + this.username + "\n password = "
                + this.password + "\\n driverClassName = " + this.driverClassName;
    }


}
