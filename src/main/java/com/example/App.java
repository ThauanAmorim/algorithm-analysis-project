package com.example;

import java.util.Arrays;
import java.util.List;

import com.example.utils.ArrayGenerator;

public class App {
    public static void main( String[] args ) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();

        arrayGenerator.almostOrdered(10, 70);
        
        System.out.println(arrayGenerator.toString());
    }
}
