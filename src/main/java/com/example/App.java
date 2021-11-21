package com.example;

import com.example.algorithms.InsertionSort;
import com.example.utils.ArrayGenerator;

public class App {
    public static void main( String[] args ) {
        ArrayGenerator generator = new ArrayGenerator();
        InsertionSort sort = new InsertionSort();

        Integer[] array = generator.random(10);

        Long time = sort.calculateTime(array);
        System.out.println(time + "ns");
        
    }
}
