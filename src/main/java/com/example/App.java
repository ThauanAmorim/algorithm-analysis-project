package com.example;
import com.example.utils.ArrayGenerator;

public class App {
    public static void main( String[] args ) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();

        arrayGenerator.random(10);
        System.out.println(arrayGenerator.toString());
    }
}
