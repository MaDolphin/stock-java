package com.dolphin.controller;

import com.dolphin.entity.StockCode;
import com.dolphin.rabbit.Sender;
import com.dolphin.service.StockService;
import com.dolphin.util.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


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
    public String index() {
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

    @RequestMapping("/search")
    public String search(Model model, HttpSession session, RedirectAttributes attr, String tags) {
        StockCode stockCode = new StockCode();
        stockCode = stockService.findByCodeOrName(tags);
        if(stockCode != null){
            session.setAttribute("stock", stockCode);
            attr.addAttribute("code", stockCode.getCode());
            return "redirect:/stock/stockMain";
        }else {
            return "index";
        }

    }

    @RequestMapping("/stockMain")
    public String stockMain(Model model) {
        return "stock-main";
    }

}
