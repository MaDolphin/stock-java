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
@RequestMapping("/stock")
@Controller
public class StockController {

    @Resource
    private StockService stockService;

    @Resource
    private Sender sender;

    @RequestMapping("/index")
    public String Index(Model model) {

//        model.addAttribute("name", "Dolphin");
        return "index";
    }

    @RequestMapping("/todayTick")
    public String todayTick() {
        stockService.getTodayTick("600000");
        return "a";
    }

    @RequestMapping("/realTick")
    public String realTick() {
        stockService.getRealTick("600000");
        return "a";
    }

    @RequestMapping("/historyData")
    public String historyData() {
        stockService.getHistoryData("600000");
        return "a";
    }

}
