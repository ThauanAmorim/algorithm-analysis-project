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

    public Integer[] inverselyOrdered(int quantity) {
        array = new Integer[quantity];
        int index = 0;
        
        for(int i = quantity-1; i >= 0; i--) {
            array[index++] = i;
        }
        return array;
    }
}
