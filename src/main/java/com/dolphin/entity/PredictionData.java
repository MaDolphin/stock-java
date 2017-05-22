package com.dolphin.entity;

import java.sql.Date;

/**
 * Created by I337852 on 5/15/2017.
 */

public class PredictionData {

    private int id;

    private String stockid;

    private Date date;

    private int type;

    private double value;

    private int order;

    public PredictionData() {
        super();
    }

    public PredictionData(String stockid, Date date, int type, double value, int order) {
        this.stockid = stockid;
        this.date = date;
        this.type = type;
        this.value = value;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockid() {
        return stockid;
    }

    public void setStockid(String stockid) {
        this.stockid = stockid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PredictionData{" +
                "id=" + id +
                ", stockid='" + stockid + '\'' +
                ", date=" + date +
                ", type=" + type +
                ", value=" + value +
                ", order=" + order +
                '}';
    }
}
