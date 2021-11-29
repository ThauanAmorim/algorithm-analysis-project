package com.example;

import com.example.algorithms.InsertionSort;
import com.example.entities.ArrayContainer;
import com.example.utils.ArrayGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private InsertionSort insertionSort;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        ArrayGenerator generator = new ArrayGenerator();
        int lenght = 1000;

        ArrayContainer arrayContainer = null;
        
        arrayContainer = generator.ordered(lenght);
        insertionSort.calculateTime(arrayContainer);
        insertionSort.resetRunNumber();

        arrayContainer = generator.inverselyOrdered(lenght);
        insertionSort.calculateTime(arrayContainer);
        insertionSort.resetRunNumber();

        for(int i = 0; i < 14; i++) {
            arrayContainer = generator.almostOrdered(lenght, 35);
            insertionSort.calculateTime(arrayContainer);
        }
        insertionSort.resetRunNumber();

        for(int i = 0; i < 14; i++) {
            arrayContainer = generator.random(lenght);
            insertionSort.calculateTime(arrayContainer);
        }
    }
}
