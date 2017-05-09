package com.dolphin.controller;

import com.dolphin.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by huang on 2017/5/8.
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Resource
    private StockService stockService;

//    @RequestMapping("/todayTick")
//    public String realTick() {
//        String str = stockService.getTodayTick("600000");
//        return str;
//    }
}
