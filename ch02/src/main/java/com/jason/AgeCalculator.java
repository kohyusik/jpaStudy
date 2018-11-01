package com.jason;

public class AgeCalculator {
    
    public static int calculate(int a, int b, AgeOperator operator) {
        
        return operator.operate(a, b);
    }
}