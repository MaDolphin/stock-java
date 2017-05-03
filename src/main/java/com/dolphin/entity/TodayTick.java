package com.dolphin.entity;

import java.util.Date;

/**
 * Created by I337852 on 5/3/2017.
 */
public class TodayTick {
    private Date time;
    private double price;
    private double pchange;
    private double change;
    private double volume;
    private int amount;
    private String type;

    public TodayTick() {
        super();
    }

    public TodayTick(Date time, double price, double pchange, double change, double volume, int amount, String type) {
        this.time = time;
        this.price = price;
        this.pchange = pchange;
        this.change = change;
        this.volume = volume;
        this.amount = amount;
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public double getPchange() {
        return pchange;
    }

    public double getChange() {
        return change;
    }

    public double getVolume() {
        return volume;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TodayTick{" +
                "time=" + time +
                ", price=" + price +
                ", pchange=" + pchange +
                ", change=" + change +
                ", volume=" + volume +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
