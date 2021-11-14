package com.example;

import com.example.utils.ArrayGenerator;

public class App {
    public static void main( String[] args ) {
        Integer[] array = null;
        ArrayGenerator arrayGenerator = new ArrayGenerator();

        array = arrayGenerator.ordered(1000000);
        System.out.println(array[999999]);
    }
}
