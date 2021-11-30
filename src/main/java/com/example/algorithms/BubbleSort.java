package com.example.algorithms;

import org.springframework.stereotype.Service;

@Service
public class BubbleSort extends AlgorithmBase {
    @Override
    protected void run(Integer[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    this.result.addComparisonsNumber(1);
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    this.result.addRegisterMovimentNumber(3);
                }
                this.result.addComparisonsNumber(1);
            }
        }
    }
}
