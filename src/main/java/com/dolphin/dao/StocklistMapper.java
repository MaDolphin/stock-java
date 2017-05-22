package com.dolphin.dao;

import com.dolphin.entity.StockCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by I337852 on 5/22/2017.
 */
@Mapper
public interface StocklistMapper {

    @Select("select * from stocklist s where s.code like '${str}%' or s.name like '%${str}%' LIMIT 10")
    public List<StockCode> findLikeCodeOrName(@Param("str") String str);

    @Select("select * from stocklist s where s.code = #{str} or s.name = #{str}")
    public StockCode findByCodeOrName(@Param("str") String str);
}
