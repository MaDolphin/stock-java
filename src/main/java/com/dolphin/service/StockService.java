package com.dolphin.service;

import com.alibaba.fastjson.JSONObject;
import com.dolphin.dao.PredictionMapper;
import com.dolphin.dao.StocklistMapper;
import com.dolphin.entity.*;
import com.dolphin.util.Convert;
import com.dolphin.util.DateUtil;
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
    private PredictionMapper predictionMapper;

    @Resource
    private StocklistMapper stocklistMapper;

    private String hostUrl = "http://127.0.0.1:8000/";

    public List<TodayTick> getTodayTick(String stockId){
        String url = hostUrl + "today_tick/?id=" + stockId;
        String str = HttpClientUtil.get(url);
        str = str.replaceAll("\\\\","");
//        str = str.replaceAll("--","0");
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

    public List<TodayTick> getTodayDateTick(String stockId,String day){
        String url = null;
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        date = calendar.getTime();
        if(day.equals("week")){
            url = hostUrl + "todaydate_tick/?id=" + stockId + "&date=" + DateUtil.getFriday(date);
        }else {
            url = hostUrl + "todaydate_tick/?id=" + stockId + "&date=" + DateUtil.afterNDay(-1);
        }
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
            temp.setPchange(0.0);
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

    public List<PredictionData> getPredictionData(String stockId){
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(calendar.getTime());

        List<PredictionData> predictionDataList = predictionMapper.findByStockidAndDate(stockId,time);

        return predictionDataList;

    }

    public List<StockCode> findLikeCodeOrName(String str){
        List<StockCode> stockCodeList = stocklistMapper.findLikeCodeOrName(str);
        return stockCodeList;
    }

    public StockCode findByCodeOrName(String str){
        StockCode stockCode = stocklistMapper.findByCodeOrName(str);
        return stockCode;
    }

}
