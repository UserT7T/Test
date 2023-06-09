package com.example.aplication2;

public class ComplexNumber extends Number {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    @Override
    public ComplexNumber add(Number num) {
        double real = this.real + ((ComplexNumber) num).getReal();
        double imaginary = this.imaginary + ((ComplexNumber) num).getImaginary();
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public ComplexNumber subtract(Number num) {
        double real = this.real - ((ComplexNumber) num).getReal();
        double imaginary = this.imaginary - ((ComplexNumber) num).getImaginary();
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public ComplexNumber multiply(Number num) {
        double real = this.real * ((ComplexNumber) num).getReal() - this.imaginary * ((ComplexNumber) num).getImaginary();
        double imaginary = this.real * ((ComplexNumber) num).getImaginary() + this.imaginary * ((ComplexNumber) num).getReal();
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public ComplexNumber divide(Number num) {
        double denominator = Math.pow(((ComplexNumber) num).getReal(), 2) + Math.pow(((ComplexNumber) num).getImaginary(), 2);
        double real = (this.real * ((ComplexNumber) num).getReal() + this.imaginary * ((ComplexNumber) num).getImaginary()) / denominator;
        double imaginary = (this.imaginary * ((ComplexNumber) num).getReal() - this.real * ((ComplexNumber) num).getImaginary()) / denominator;
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public String toString() {
        String sign = imaginary < 0 ? "-" : "+";
        return real + sign + Math.abs(imaginary) + "i";
    }
}