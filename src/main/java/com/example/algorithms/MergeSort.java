package com.example.algorithms;

import org.springframework.stereotype.Service;

@Service
public class MergeSort extends AlgorithmBase {

    @Override
    protected void run(Integer[] array) {
        mergeSort(array, array.length);

    }

    private void mergeSort(Integer[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Integer[] l = new Integer[mid];
        Integer[] r = new Integer[n - mid];
    
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
            this.result.addRegisterMovimentNumber(1);
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
            this.result.addRegisterMovimentNumber(1);
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
    
        merge(a, l, r, mid, n - mid);
    }
    
    private void merge(Integer[] a, Integer[] l, Integer[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                this.result.addComparisonsNumber(1);
                a[k++] = l[i++];
                this.result.addRegisterMovimentNumber(1);
            }
            else {
                this.result.addComparisonsNumber(1);
                a[k++] = r[j++];
                this.result.addRegisterMovimentNumber(1);
            }
        }
        while (i < left) {
            a[k++] = l[i++];
            this.result.addRegisterMovimentNumber(1);
        }
        while (j < right) {
            a[k++] = r[j++];
            this.result.addRegisterMovimentNumber(1);
        }
    }
}
