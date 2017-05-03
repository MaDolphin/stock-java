package com.dolphin.controller;

import com.dolphin.rabbit.Sender;
import com.dolphin.service.StockService;
import com.dolphin.util.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Created by huang on 2017/5/1.
 */
@RestController
public class TestController {

    @Resource
    private StockService stockService;

    @Autowired
    private Sender sender;

    @RequestMapping("/")
    public String index() {
        return "Index Page";
    }

    @RequestMapping("/rabbitmq")
    public String hello() {
        String context = "601766";
        sender.send(context);
        return "Hello World!";
    }

    @RequestMapping("/main")
    public String main() {
        stockService.getTodayTick("600000");
        return "Main";
    }



}
