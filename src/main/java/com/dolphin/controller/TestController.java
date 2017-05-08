package com.dolphin.controller;

import com.dolphin.rabbit.Sender;
import com.dolphin.service.StockService;
import com.dolphin.util.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Created by huang on 2017/5/1.
 */
@RequestMapping("/main")
@Controller
public class TestController {

    @Resource
    private StockService stockService;

    @Autowired
    private Sender sender;

    @RequestMapping("/index")
    public String Index(Model model) {
//        model.addAttribute("name", "Dolphin");
        return "index";
    }

    @RequestMapping("/te")
    public String Test(Model model) {
        return "techanjs";
    }

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
