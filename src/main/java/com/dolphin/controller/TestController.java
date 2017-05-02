package com.dolphin.controller;

import com.dolphin.rabbit.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huang on 2017/5/1.
 */
@RestController
public class TestController {

    @Autowired
    private Sender sender;

    @RequestMapping("/")
    public String index() {
        return "Index Page";
    }

    @RequestMapping("/rabbitmq")
    public String hello() {
        String context = "AAA";
        sender.send(context);
        return "Hello World!";
    }
}
