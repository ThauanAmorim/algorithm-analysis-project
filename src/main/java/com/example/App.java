package com.example;

import java.util.Arrays;
import java.util.List;

import com.example.utils.ArrayGenerator;

public class App {
    public static void main( String[] args ) {
        Integer[] array = null;
        ArrayGenerator arrayGenerator = new ArrayGenerator();

        array = arrayGenerator.ordered(1000000);
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}
