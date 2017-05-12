package com.dolphin.entity;

import java.sql.Time;
import java.util.Date;

/**
 * Created by I337852 on 5/3/2017.
 */
public class TodayTick implements Comparable<TodayTick> {
    private int index;
    private String time;
    private double price;
    private double pchange;
    private double change;
    private double volume;
    private int amount;
    private String type;

    public TodayTick() {
        super();
    }

    public TodayTick(int index, String time, double price, double pchange, double change, double volume, int amount, String type) {
        this.index = index;
        this.time = time;
        this.price = price;
        this.pchange = pchange;
        this.change = change;
        this.volume = volume;
        this.amount = amount;
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPchange() {
        return pchange;
    }

    public void setPchange(double pchange) {
        this.pchange = pchange;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TodayTick{" +
                "index=" + index +
                ", time='" + time + '\'' +
                ", price=" + price +
                ", pchange=" + pchange +
                ", change=" + change +
                ", volume=" + volume +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int compareTo(TodayTick todayTick) {
        return Long.valueOf(this.getIndex()).compareTo(Long.valueOf(todayTick.getIndex()));
    }
}
