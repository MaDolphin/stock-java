package com.dolphin.controller;

import com.dolphin.entity.*;
import com.dolphin.rabbit.Sender;
import com.dolphin.service.StockService;
import com.dolphin.util.DateUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
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
        List<TodayTick> todayTickList = new ArrayList<TodayTick>();
        Calendar now = Calendar.getInstance();
        //一周第一天是否为星期天
        boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取周几
        int weekDay = now.get(Calendar.DAY_OF_WEEK);
        //若一周第一天为星期天，则-1
        if(isFirstSunday){
            weekDay = weekDay - 1;
            if(weekDay == 0){
                weekDay = 7;
            }
        }
        if(weekDay == 6 || weekDay == 7){
            todayTickList = stockService.getTodayDateTick(stockId,"week");
        }else {
            Calendar cnow = Calendar.getInstance();
            String time = now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE);
//            System.out.println(time);
            if(DateUtil.isInTime("00:00-09:30", time)){
                todayTickList = stockService.getTodayDateTick(stockId,"day");
            }else {
                todayTickList = stockService.getTodayTick(stockId);
            }

        }
        Collections.sort(todayTickList);
        return todayTickList;
    }

    @RequestMapping(value = "/getRestPredictionData/{stockId}", method = RequestMethod.GET)
    public List<PredictionData> getRestPredictionData(@PathVariable(value="stockId") String stockId) {
        List<PredictionData> predictionDataList = stockService.getPredictionData(stockId);
        if(predictionDataList.size() == 0){
            sender.send(stockId);
        }
        return predictionDataList;
    }

    @RequestMapping(value = "/searchStock/{str}", method = RequestMethod.GET)
    public List<StockCode> searchStock(@PathVariable(value="str") String str) {
        return stockService.findLikeCodeOrName(str);
    }

    @RequestMapping("/rabbitmq")
    public String hello() {
        String context = "600000";
        sender.send(context);
        return "Hello World!";
    }


}
