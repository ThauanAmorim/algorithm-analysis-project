package com.example;

import java.util.Arrays;
import java.util.List;

import com.example.utils.ArrayGenerator;

public class App {
    public static void main( String[] args ) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();

        arrayGenerator.inverselyOrdered(1000000);
        System.out.println(arrayGenerator.getArray()[0]);
    }
}
