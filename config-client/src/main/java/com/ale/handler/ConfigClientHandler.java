package com.ale.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cfg")
public class ConfigClientHandler {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/info")
    public String info() {
        return this.port;
    }

}
