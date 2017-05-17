package com.dolphin.dao;

import com.dolphin.entity.PredictionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by I337852 on 5/15/2017.
 */
@Repository
public interface  StockRepository extends JpaRepository<PredictionData, Integer> {

    @Modifying
    public List<PredictionData> findByStockidAndDate(String stockid, Date date);

    @Modifying
    public List<PredictionData> findAll();

}
