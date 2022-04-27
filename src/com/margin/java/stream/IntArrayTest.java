package com.margin.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntArrayTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(arr).sum();
        int count = (int) Arrays.stream(arr).count();

        System.out.println("sum = " + sum);
        System.out.println("count = " + count);
        System.out.println("=========================================");


        Arrays.stream(arr).filter(e -> e > 3).forEach(e -> System.out.println("e = " + e));
        Arrays.stream(arr).map(e -> e + 10).forEach(element -> System.out.println("element = " + element));

    }

}
