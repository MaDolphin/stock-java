package com.dolphin.dao;

import com.dolphin.entity.PredictionData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.util.List;

/**
 * Created by I337852 on 5/22/2017.
 */
@Mapper
public interface PredictionMapper {

    @Select("select * from prediction p where p.stockid = #{stockid} and p.date = #{date}")
    public List<PredictionData> findByStockidAndDate(@Param("stockid") String stockid,@Param("date") String date);
}
