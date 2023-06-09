package com.example.aplication2;

public class DecimalNumber extends Number {
    private double value;

    public DecimalNumber(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public DecimalNumber add(Number num) {
        return new DecimalNumber(value + ((DecimalNumber) num).getValue());
    }

    @Override
    public DecimalNumber subtract(Number num) {
        return new DecimalNumber(value - ((DecimalNumber) num).getValue());
    }

    @Override
    public DecimalNumber multiply(Number num) {
        return new DecimalNumber(value * ((DecimalNumber) num).getValue());
    }

    @Override
    public DecimalNumber divide(Number num) {
        return new DecimalNumber(value / ((DecimalNumber) num).getValue());
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}