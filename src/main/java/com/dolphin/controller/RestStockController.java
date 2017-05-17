package com.dolphin.controller;

import com.dolphin.entity.*;
import com.dolphin.rabbit.Sender;
import com.dolphin.service.StockService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by I337852 on 5/11/2017.
 */
@RequestMapping("/restStock")
@RestController
public class RestStockController {

    @Resource
    private StockService stockService;

    @Resource
    private Sender sender;

    @RequestMapping(value = "/getRestHistoryData/{stockId}", method = RequestMethod.GET)
    public RestHistoryData getRestHistoryData(@PathVariable(value="stockId") String stockId) {
        List<HistoryData> historyDataList = stockService.getHistoryData(stockId);
        Collections.sort(historyDataList);

        RealTick realTick = stockService.getRealTick(stockId);
        String vl = "";
        for (int i =0; i<historyDataList.size(); i++){
            vl = vl + historyDataList.get(i).getDate().getTime() + "^";
            vl = vl + historyDataList.get(i).getOpen() + "^";
            vl = vl + historyDataList.get(i).getClose() + "^";
            vl = vl + historyDataList.get(i).getHigh() + "^";
            vl = vl + historyDataList.get(i).getLow() + "^";
            vl = vl + Math.round(historyDataList.get(i).getVolume()) + "^";
            vl = vl + "null" + "^";
            vl = vl + historyDataList.get(i).getpChange() + "^";
            vl = vl + historyDataList.get(i).getPriceChange() + "^";
            vl = vl + historyDataList.get(i).getTurnover() + "^";
            vl = vl + historyDataList.get(i).getClose() + "^";
            vl = vl + historyDataList.get(i).getMa5() + "^";
            vl = vl + historyDataList.get(i).getMa10() + "^";
            vl = vl + historyDataList.get(i).getMa20() + "^";
            vl = vl + "null" + "^";
            vl = vl + "null" + "~";
        }
        RestHistoryData restHistoryData = new RestHistoryData();
        restHistoryData.setVl(vl);
        restHistoryData.setCcode(stockId+".sh");
        restHistoryData.setCname(realTick.getName());
        restHistoryData.setTag(realTick.getName());
        return restHistoryData;
    }

    @RequestMapping(value = "/getRestHistoryTime/{stockId}", method = RequestMethod.GET)
    public List<HistoryData> getRestHistoryTime(@PathVariable(value="stockId") String stockId) {
        List<HistoryData> historyDataList = stockService.getHistoryData(stockId);
        Collections.sort(historyDataList);
        return historyDataList;
    }

    @RequestMapping(value = "/getRestRealTick/{stockId}", method = RequestMethod.GET)
    public RealTick getRestRealTick(@PathVariable(value="stockId") String stockId) {
        return stockService.getRealTick(stockId);
    }

    @RequestMapping(value = "/getRestTodayTick/{stockId}", method = RequestMethod.GET)
    public List<TodayTick> getRestTodayTick(@PathVariable(value="stockId") String stockId) {
        List<TodayTick> todayTickList = stockService.getTodayTick(stockId);
        Collections.sort(todayTickList);
        return todayTickList;
    }

    @RequestMapping(value = "/getRestPredictionData/{stockId}", method = RequestMethod.GET)
    public List<PredictionData> getRestPredictionData(@PathVariable(value="stockId") String stockId) {
        return stockService.getPredictionData(stockId);
    }

    @RequestMapping("/rabbitmq")
    public String hello() {
        String context = "600000";
        sender.send(context);
        return "Hello World!";
    }


}
