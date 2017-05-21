package com.dolphin.dao;

import com.dolphin.entity.PredictionData;
import com.dolphin.entity.StockCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by huang on 2017/5/21.
 */
@Repository
public interface  CodeRepository extends JpaRepository<StockCode, String> {

    @Query("select s from StockCode s where s.code like %?1 or s.name like %?1")
    public List<StockCode> findLikeCodeOrName(String str);

    @Query("select s from StockCode s where s.code=?1 or s.name=?1")
    public StockCode findByCodeOrName(String str);

}