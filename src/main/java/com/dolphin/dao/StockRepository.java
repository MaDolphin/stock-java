package com.dolphin.dao;

import com.dolphin.entity.PredictionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by I337852 on 5/15/2017.
 */
@Repository
public interface  StockRepository extends JpaRepository<PredictionData, Integer> {

    @Query("select p from PredictionData p where p.stockid=?1 and p.date=?2")
    public List<PredictionData> findByStockidAndDate(String stockId, Date date);

    @Modifying
    public List<PredictionData> findAll();

}
