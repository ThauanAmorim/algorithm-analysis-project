package com.example;

import com.example.algorithms.BubbleSort;
import com.example.algorithms.InsertionSort;
import com.example.algorithms.MergeSort;
import com.example.algorithms.QuickSort;
import com.example.algorithms.SelectionSort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private BubbleSort bubbleSort;
    @Autowired
    private InsertionSort insertionSort;
    @Autowired
    private MergeSort mergeSort;
    @Autowired
    private QuickSort quickSort;
    @Autowired
    private SelectionSort selectionSort;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        bubbleSort.initCalculate();
        System.out.println("\n\n\n");

        insertionSort.initCalculate();
        System.out.println("\n\n\n");

        mergeSort.initCalculate();
        System.out.println("\n\n\n");

        quickSort.initCalculate();
        System.out.println("\n\n\n");

        selectionSort.initCalculate();
        System.out.println("\n\n\n");
    }
}
