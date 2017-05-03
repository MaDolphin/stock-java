package com.dolphin.service;

import com.dolphin.entity.TodayTick;
import com.dolphin.util.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by I337852 on 5/3/2017.
 */
@Service("stockService")
public class StockService {

    public List<TodayTick> getTodayTick(String stockId){
        String url = "http://127.0.0.1:8000/today_tick/?id=" + stockId;
        String str = HttpClientUtil.get(url);
        this.json2Javas(str);
        return null;
    }

//    public List<TodayTick> json2Javas(String jsons) {
//        List<TodayTick> todayTicks = getJavaCollection(new TodayTick(), jsons);
//        System.out.println(todayTicks.size());
//        for(TodayTick todayTick:todayTicks){
//            System.out.println("addTime: "+todayTick.getTime());
//            System.out.println("=========");
//        }
//        return todayTicks;
//    }

    public void json2Javas(String json) {
        json = "[{\"time\":\"09:25:01\",\"price\":15.16,\"pchange\":\"0.00\",\"change\":0.0,\"volume\":139,\"amount\":210724,\"type\":\"0\"}";
        if(json.indexOf("[")!=-1){
            json=json.replace("[", "");
        }
        if(json.indexOf("]")!=-1){
            json=json.replace("]", "");
        }
        JSONObject obj=new JSONObject().fromObject(json);
        TodayTick todayTick=(TodayTick) JSONObject.toBean(obj, TodayTick.class);
        System.out.println(todayTick.getTime());
    }

    private <T> List<T> getJavaCollection(T clazz, String jsons) {
        if(jsons.indexOf("[")!=-1){
            jsons=jsons.replace("[", "");
        }
        if(jsons.indexOf("]")!=-1){
            jsons=jsons.replace("]", "");
        }
        jsons = jsons.replaceAll("\\\\","");
        System.out.println(jsons);
        List<T> objs = null;
        JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsons);
        if (jsonArray != null) {
            objs = new ArrayList<T>();
            List list = (List) JSONSerializer.toJava(jsonArray);
            for (Object o : list) {
                JSONObject jsonObject = JSONObject.fromObject(o);
                T obj = (T) JSONObject.toBean(jsonObject, clazz.getClass());
                objs.add(obj);
            }
        }
        return objs;
    }
}
