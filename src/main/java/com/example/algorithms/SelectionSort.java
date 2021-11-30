package com.example.algorithms;

import org.springframework.stereotype.Service;

@Service
public class SelectionSort extends AlgorithmBase {
    @Override
    protected void run(Integer[] array) {
        int j;
        int key;
        int i;

        for (j = 1; j < array.length; j++) {
            key = array[j];
            this.result.addRegisterMovimentNumber(1);
            for (i = j - 1; (i >= 0) && (array[i] > key); i--) {
                this.result.addComparisonsNumber(1);
                array[i + 1] = array[i];
                this.result.addRegisterMovimentNumber(1);
            }
            this.result.addRegisterMovimentNumber(1);
            array[i + 1] = key;
            this.result.addRegisterMovimentNumber(1);
        }
    }
}
