package com.margin.java.lambda;

public class TestStringConcat {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        StringConcat stringConcat = (s, v) -> System.out.println(s + ", " + v);
        stringConcat.makeString(s1, s2);
    }
}
