package com.example.algorithms;

import java.util.concurrent.TimeUnit;

import com.example.entities.ArrayContainer;
import com.example.entities.Result;
import com.example.repository.ResultRepository;
import com.example.utils.ArrayGenerator;
import com.google.common.base.Stopwatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AlgorithmBase {
    private Stopwatch timer;

    private Integer runNumber = 0;

    protected Result result;

    private ArrayContainer arrayContainer;

    @Autowired
    protected ResultRepository repository;

    public AlgorithmBase() {
        timer = Stopwatch.createUnstarted();
    }

    protected abstract Integer[] run(Integer[] array);

    protected void calculate(ArrayContainer arrayContainerInput) {
        result = new Result();
        arrayContainer = arrayContainerInput;
        
        // toPrint(array);
        timer.start();
        run(arrayContainer.getArray());
        timer.stop();
        // toPrint(array);
        result.setTime(timer.elapsed(TimeUnit.MICROSECONDS));
        result.setAlgorithmName(getClass().getSimpleName());
        result.setArrayType(arrayContainer.getArrayType());
        result.setLenght(arrayContainer.getLenght());
        result.setRun(++runNumber);

        repository.save(result);
    }

    public void resetRunNumber() {
        this.runNumber = 0;
    }

    public void initCalculate() {
        ArrayGenerator generator = new ArrayGenerator();

        // Integer[] lenghts = {10, 100, 1000, 10000, 100000};
        Integer[] lenghts = {1000000};

        for(Integer value : lenghts) {
            ArrayContainer arrayContainer = null;
            
            arrayContainer = generator.ordered(value);
            calculate(arrayContainer);
            resetRunNumber();
    
            arrayContainer = generator.inverselyOrdered(value);
            calculate(arrayContainer);
            resetRunNumber();
    
            for(int i = 0; i < 14; i++) {
                arrayContainer = generator.almostOrdered(value, 35);
                calculate(arrayContainer);
            }
            resetRunNumber();
    
            for(int i = 0; i < 14; i++) {
                arrayContainer = generator.random(value);
                calculate(arrayContainer);
            }
        }
    }

    // private void toPrint(Integer[] array) {
    //     String text = "[";
    //     for (int i = 0; i < array.length-1; i++) {
    //         text += array[i] + ", ";
    //     }
    //     text += array[array.length-1] + "]";
    //     System.out.println(text);
    // }
}
