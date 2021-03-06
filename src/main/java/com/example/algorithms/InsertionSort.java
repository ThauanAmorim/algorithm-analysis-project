package com.example.algorithms;

import org.springframework.stereotype.Service;

@Service
public class InsertionSort extends AlgorithmBase {

    @Override
    protected void run(Integer[] array) {
        int i, key, j;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            this.result.addRegisterMovimentNumber(1);
            j = i - 1;
            while (j >= 0 && array[j] > key) {
                this.result.addComparisonsNumber(1);
                array[j + 1] = array[j];
                this.result.addRegisterMovimentNumber(1);
                j = j - 1;
            }
            this.result.addComparisonsNumber(1);
            array[j + 1] = key;
            this.result.addRegisterMovimentNumber(1);
        }
    }
}
