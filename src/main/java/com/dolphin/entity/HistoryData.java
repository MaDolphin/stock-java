package com.dolphin.entity;

import java.util.Date;

/**
 * Created by huang on 2017/5/8.
 */
public class HistoryData implements Comparable<HistoryData> {
    private Date date;

    private double open;
    private double high;
    private double close;
    private double low;
    private double volume;
    private double priceChange;
    private double pChange;
    private double ma5;
    private double ma10;
    private double ma20;
    private double vMa5;
    private double vMa10;
    private double vMa20;
    private double turnover;

    public HistoryData() {
        super();
    }

    public HistoryData(Date date, double open, double high, double close, double low, double volume, double priceChange, double pChange, double ma5, double ma10, double ma20, double vMa5, double vMa10, double vMa20, double turnover) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.close = close;
        this.low = low;
        this.volume = volume;
        this.priceChange = priceChange;
        this.pChange = pChange;
        this.ma5 = ma5;
        this.ma10 = ma10;
        this.ma20 = ma20;
        this.vMa5 = vMa5;
        this.vMa10 = vMa10;
        this.vMa20 = vMa20;
        this.turnover = turnover;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }

    public double getpChange() {
        return pChange;
    }

    public void setpChange(double pChange) {
        this.pChange = pChange;
    }

    public double getMa5() {
        return ma5;
    }

    public void setMa5(double ma5) {
        this.ma5 = ma5;
    }

    public double getMa10() {
        return ma10;
    }

    public void setMa10(double ma10) {
        this.ma10 = ma10;
    }

    public double getMa20() {
        return ma20;
    }

    public void setMa20(double ma20) {
        this.ma20 = ma20;
    }

    public double getvMa5() {
        return vMa5;
    }

    public void setvMa5(double vMa5) {
        this.vMa5 = vMa5;
    }

    public double getvMa10() {
        return vMa10;
    }

    public void setvMa10(double vMa10) {
        this.vMa10 = vMa10;
    }

    public double getvMa20() {
        return vMa20;
    }

    public void setvMa20(double vMa20) {
        this.vMa20 = vMa20;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return "HistoryData{" +
                "date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", close=" + close +
                ", low=" + low +
                ", volume=" + volume +
                ", priceChange=" + priceChange +
                ", pChange=" + pChange +
                ", ma5=" + ma5 +
                ", ma10=" + ma10 +
                ", ma20=" + ma20 +
                ", vMa5=" + vMa5 +
                ", vMa10=" + vMa10 +
                ", vMa20=" + vMa20 +
                ", turnover=" + turnover +
                '}';
    }

    @Override
    public int compareTo(HistoryData historyData) {
       return Long.valueOf(this.getDate().getTime()).compareTo(historyData.getDate().getTime());
    }

}
