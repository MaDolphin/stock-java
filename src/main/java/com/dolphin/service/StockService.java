package com.dolphin.service;

import com.alibaba.fastjson.JSONObject;
import com.dolphin.dao.StockRepository;
import com.dolphin.entity.HistoryData;
import com.dolphin.entity.PredictionData;
import com.dolphin.entity.RealTick;
import com.dolphin.entity.TodayTick;
import com.dolphin.util.Convert;
import com.dolphin.util.HttpClientUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by I337852 on 5/3/2017.
 */
@Service("stockService")
public class StockService {

    @Resource
    private StockRepository stockRepository;

    private String hostUrl = "http://127.0.0.1:8000/";

    public List<TodayTick> getTodayTick(String stockId){
        String url = hostUrl + "today_tick/?id=" + stockId;
        String str = HttpClientUtil.get(url);
        str = str.replaceAll("\\\\","");
        str = str.substring(1, str.length());
        str = str.substring(0,str.length()-1);
        str = Convert.camelCaseName(str);
        List<TodayTick> todayTick = new ArrayList<TodayTick>();
        TodayTick temp = new TodayTick();
        JSONObject jsonObject = JSONObject.parseObject(str);
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
            JSONObject result = jsonObject.getJSONObject(entry.getKey().toString());
            temp = JSONObject.parseObject(result.toJSONString(), TodayTick.class);
            temp.setIndex(Integer.valueOf(entry.getKey()));
            String strTemp = temp.getType();
            strTemp = strTemp.replaceAll("u","\\\\\\u");
//            System.out.println(strTemp);
            temp.setType(Convert.decodeUnicode(strTemp));
            todayTick.add(temp);
        }
        return todayTick;
    }

    public RealTick getRealTick(String stockId){
        String url = hostUrl + "real_tick/?id=" + stockId;
        String str = HttpClientUtil.get(url);
        str = str.replaceAll("\\\\","");
        str = str.substring(1, str.length());
        str = str.substring(0,str.length()-1);
        str = Convert.camelCaseName(str);
        RealTick realTick = null;
        JSONObject jsonObject = JSONObject.parseObject(str);
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
            JSONObject result = jsonObject.getJSONObject(entry.getKey().toString());
            realTick = JSONObject.parseObject(result.toJSONString(), RealTick.class);
            String strTemp = realTick.getName();
            strTemp = strTemp.replaceAll("u","\\\\\\u");
//            System.out.println(strTemp);
            realTick.setName(Convert.decodeUnicode(strTemp));
//            int a = realTick.getB1V();
//            String c = String.valueOf(System.currentTimeMillis());
//            String b = String.valueOf(System.currentTimeMillis()).substring(10,12);
//            realTick.setB1V(a + Integer.parseInt(b));
        }
        return realTick;
    }

    public List<HistoryData> getHistoryData(String stockId){
        String url = hostUrl + "history_data/?id=" + stockId;
        String str = HttpClientUtil.get(url);
        str = str.replaceAll("\\\\","");
        str = str.substring(1, str.length());
        str = str.substring(0,str.length()-1);
        str = Convert.camelCaseName(str);
        List<HistoryData> historyData = new ArrayList<HistoryData>();
        HistoryData temp = new HistoryData();
        SimpleDateFormat sdf = new SimpleDateFormat();
        JSONObject jsonObject = JSONObject.parseObject(str);
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            JSONObject result = jsonObject.getJSONObject(entry.getKey().toString());
            temp = JSONObject.parseObject(result.toJSONString(), HistoryData.class);
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                temp.setDate(sdf.parse(entry.getKey()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            System.out.println(temp.getDate().toString());
            historyData.add(temp);
        }
        return historyData;
    }

    public String getHistoryDatatoString(String stockId){
        String traget = null;
        List<HistoryData> list = this.getHistoryData(stockId);
        for(int i=0;i<list.size();i++){

        }
        return traget;
    }

    public List<PredictionData> getPredictionData(String stockId){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date time=null;
        try {
            time= sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println(time);
//        List<PredictionData> predictionDataList = stockRepository.findByStockidAndDate(stockId,time);
        List<PredictionData> predictionDataList = stockRepository.findAll();
        return predictionDataList;
    }

}
