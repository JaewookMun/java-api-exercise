package com.margin.java.lambda.param;

public class LamdaTestApp {
    public static void main(String[] args) {
        // 변수에 대입히는 방법
        PrintString printString = str -> {
            System.out.println(str);
        };
        printString.showString("람다식을 변수에 대입");
        
        
        // 메서드의 파라미터에 대입
        showStringByLambdaParam(str -> {
            System.out.println(str);
        });
    }

    public static void showStringByLambdaParam(PrintString printString) {
        printString.showString("람다식을 파라미터에 대입");
    }
}
