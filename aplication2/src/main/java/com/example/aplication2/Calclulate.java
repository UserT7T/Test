package com.example.aplication2;

public class Calclulate {
    public float calculateUnaryNumber(float number1, String operator){
        switch (operator) {
            case "√":
                return (long)Math.sqrt(number1);


            default:
                break;
        }
        return 0;
    }
    public float calculateNegate(float number1, String operator){
                if (number1!=0){
                    return  number1*-1;
                }
        return 0;
    }

    public float calculateBinaryNumber(float number1, float number2, String operator){
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "÷":
                return number1 / number2;
            case "Mod":
                return number1 % number2;
            case "%":
                return ((number1/100)*number2);
            case "x^y":

                return (float) Math.pow(number1, number2);

            default:
                break;
        }
        return 0;
    }
}
