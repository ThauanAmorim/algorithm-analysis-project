package com.example.utils;

public class ArrayGenerator {
    private Integer[] array = null;

    public Integer[] ordered(int quantity) {
        array = new Integer[quantity];
        
        for(int i = 0; i< quantity; i++) {
            array[i] = i;
        }
        return array;
    } 
}
