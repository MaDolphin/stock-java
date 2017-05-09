package com.dolphin.entity;

/**
 * Created by huang on 2017/5/9.
 */
public class ResponeRealTick {
    private int number;
    private RealTick realTick;

    public ResponeRealTick() {
        super();
    }

    public ResponeRealTick(int number, RealTick realTick) {
        this.number = number;
        this.realTick = realTick;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RealTick getRealTick() {
        return realTick;
    }

    public void setRealTick(RealTick realTick) {
        this.realTick = realTick;
    }

    @Override
    public String toString() {
        return "ResponeRealTick{" +
                "number=" + number +
                ", realTick=" + realTick +
                '}';
    }
}
