package com.margin.java.lambda.returns;

public class LambdaTestTwoApp {
    public static void main(String[] args) {
        //1.
        PrintSum sum = (a, b) -> {
            int sumOfThem = a + b;
            System.out.println("result: " + sumOfThem);
        };
        sum.sum(1, 2);

        //2
        sum((a, b) -> System.out.println("second result: " + (a + b)));

        //3 반환값으로 쓰이는 람다식
        PrintSum thirdSum = returnSum();
        thirdSum.sum(1,2);

    }

    public static void sum(PrintSum printSum) {
        printSum.sum(1, 2);
    }

    public static PrintSum returnSum() {
        return (a, b) -> System.out.println("third result: " + (a + b));
    }
}
