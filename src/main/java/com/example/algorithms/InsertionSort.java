package com.example.algorithms;

import org.springframework.stereotype.Service;

@Service
public class InsertionSort extends AlgorithmBase {

    @Override
    protected Integer[] run(Integer[] array) {
        int i, key, j;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > key)
            {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
    
}
