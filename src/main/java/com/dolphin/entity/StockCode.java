package com.dolphin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by huang on 2017/5/21.
 */
@Entity
@Table(name="stocklist")
public class StockCode {
    @Id
    private String code;

    private String name;

    public StockCode() {
        super();
    }

    public StockCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StockCode{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
