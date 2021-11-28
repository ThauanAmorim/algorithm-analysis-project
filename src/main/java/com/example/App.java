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
        
        ArrayContainer arrayContainer = generator.almostOrdered(10, 50);
        insertionSort.calculateTime(arrayContainer);
        
    }
}
