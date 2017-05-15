package com.dolphin.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by I337852 on 5/15/2017.
 */
@Entity
@Table(name="prediction")
public class PredictionData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "stock")
    private String stock;
    @Column(name = "date")
    private Date date;
    @Column(name = "type")
    private int type;
    @Column(name = "value")
    private double value;
    @Column(name = "order")
    private int order;

    public PredictionData() {
        super();
    }

    public PredictionData(int id, String stock, Date date, int type, double value, int order) {
        this.id = id;
        this.stock = stock;
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

    public String getstock() {
        return stock;
    }

    public void setstock(String stock) {
        this.stock = stock;
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
                ", stock='" + stock + '\'' +
                ", date=" + date +
                ", type=" + type +
                ", value=" + value +
                ", order=" + order +
                '}';
    }
}
