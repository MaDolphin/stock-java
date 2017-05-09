package com.dolphin.entity;

import java.sql.Time;
import java.util.Date;

/**
 * Created by huang on 2017/5/8.
 */
public class RealTick {
    private String name;
    private double open;
    private double preClose;
    private double price;
    private double high;
    private double low;
    private double bid;
    private double ask;
    private int volume;
    private double amount;
    private int b1V;
    private double b1P;
    private int b2V;
    private double b2P;
    private int b3V;
    private double b3P;
    private int b4V;
    private double b4P;
    private int b5V;
    private double b5P;
    private int a1V;
    private double a1P;
    private int a2V;
    private double a2P;
    private int a3V;
    private double a3P;
    private int a4V;
    private double a4P;
    private int a5V;
    private double a5P;
    private Date date;
    private Time time;

    public RealTick() {
        super();
    }

    public RealTick(String name, double open, double preClose, double price, double high, double low, double bid, double ask, int volume, double amount, int b1V, double b1P, int b2V, double b2P, int b3V, double b3P, int b4V, double b4P, int b5V, double b5P, int a1V, double a1P, int a2V, double a2P, int a3V, double a3P, int a4V, double a4P, int a5V, double a5P, Date date, Time time) {
        this.name = name;
        this.open = open;
        this.preClose = preClose;
        this.price = price;
        this.high = high;
        this.low = low;
        this.bid = bid;
        this.ask = ask;
        this.volume = volume;
        this.amount = amount;
        this.b1V = b1V;
        this.b1P = b1P;
        this.b2V = b2V;
        this.b2P = b2P;
        this.b3V = b3V;
        this.b3P = b3P;
        this.b4V = b4V;
        this.b4P = b4P;
        this.b5V = b5V;
        this.b5P = b5P;
        this.a1V = a1V;
        this.a1P = a1P;
        this.a2V = a2V;
        this.a2P = a2P;
        this.a3V = a3V;
        this.a3P = a3P;
        this.a4V = a4V;
        this.a4P = a4P;
        this.a5V = a5V;
        this.a5P = a5P;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getPreClose() {
        return preClose;
    }

    public void setPreClose(double preClose) {
        this.preClose = preClose;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getB1V() {
        return b1V;
    }

    public void setB1V(int b1V) {
        this.b1V = b1V;
    }

    public double getB1P() {
        return b1P;
    }

    public void setB1P(double b1P) {
        this.b1P = b1P;
    }

    public int getB2V() {
        return b2V;
    }

    public void setB2V(int b2V) {
        this.b2V = b2V;
    }

    public double getB2P() {
        return b2P;
    }

    public void setB2P(double b2P) {
        this.b2P = b2P;
    }

    public int getB3V() {
        return b3V;
    }

    public void setB3V(int b3V) {
        this.b3V = b3V;
    }

    public double getB3P() {
        return b3P;
    }

    public void setB3P(double b3P) {
        this.b3P = b3P;
    }

    public int getB4V() {
        return b4V;
    }

    public void setB4V(int b4V) {
        this.b4V = b4V;
    }

    public double getB4P() {
        return b4P;
    }

    public void setB4P(double b4P) {
        this.b4P = b4P;
    }

    public int getB5V() {
        return b5V;
    }

    public void setB5V(int b5V) {
        this.b5V = b5V;
    }

    public double getB5P() {
        return b5P;
    }

    public void setB5P(double b5P) {
        this.b5P = b5P;
    }

    public int getA1V() {
        return a1V;
    }

    public void setA1V(int a1V) {
        this.a1V = a1V;
    }

    public double getA1P() {
        return a1P;
    }

    public void setA1P(double a1P) {
        this.a1P = a1P;
    }

    public int getA2V() {
        return a2V;
    }

    public void setA2V(int a2V) {
        this.a2V = a2V;
    }

    public double getA2P() {
        return a2P;
    }

    public void setA2P(double a2P) {
        this.a2P = a2P;
    }

    public int getA3V() {
        return a3V;
    }

    public void setA3V(int a3V) {
        this.a3V = a3V;
    }

    public double getA3P() {
        return a3P;
    }

    public void setA3P(double a3P) {
        this.a3P = a3P;
    }

    public int getA4V() {
        return a4V;
    }

    public void setA4V(int a4V) {
        this.a4V = a4V;
    }

    public double getA4P() {
        return a4P;
    }

    public void setA4P(double a4P) {
        this.a4P = a4P;
    }

    public int getA5V() {
        return a5V;
    }

    public void setA5V(int a5V) {
        this.a5V = a5V;
    }

    public double getA5P() {
        return a5P;
    }

    public void setA5P(double a5P) {
        this.a5P = a5P;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RealTick{" +
                "name='" + name + '\'' +
                ", open=" + open +
                ", preClose=" + preClose +
                ", price=" + price +
                ", high=" + high +
                ", low=" + low +
                ", bid=" + bid +
                ", ask=" + ask +
                ", volume=" + volume +
                ", amount=" + amount +
                ", b1V=" + b1V +
                ", b1P=" + b1P +
                ", b2V=" + b2V +
                ", b2P=" + b2P +
                ", b3V=" + b3V +
                ", b3P=" + b3P +
                ", b4V=" + b4V +
                ", b4P=" + b4P +
                ", b5V=" + b5V +
                ", b5P=" + b5P +
                ", a1V=" + a1V +
                ", a1P=" + a1P +
                ", a2V=" + a2V +
                ", a2P=" + a2P +
                ", a3V=" + a3V +
                ", a3P=" + a3P +
                ", a4V=" + a4V +
                ", a4P=" + a4P +
                ", a5V=" + a5V +
                ", a5P=" + a5P +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
