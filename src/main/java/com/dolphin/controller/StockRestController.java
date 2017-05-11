package com.dolphin.controller;

import com.dolphin.entity.HistoryData;
import com.dolphin.service.StockService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by I337852 on 5/11/2017.
 */
@RequestMapping("/restStock")
@RestController
public class StockRestController {

    @Resource
    private StockService stockService;

    @RequestMapping(value = "/getRestHistoryData/{stockId}", method = RequestMethod.GET)
    public List getRestHistoryData(@PathVariable(value="stockId") String stockId) {
        List<HistoryData> historyDataList = stockService.getHistoryData(stockId);

        return null;
    }
}
