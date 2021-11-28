package com.example.algorithms;

import java.util.concurrent.TimeUnit;

import com.example.entities.ArrayContainer;
import com.example.entities.Result;
import com.example.repository.ResultRepository;
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

    public void calculateTime(ArrayContainer arrayContainerInput) {
        result = new Result();
        arrayContainer = arrayContainerInput;
        // toPrint(array);
        timer.start();
        run(arrayContainer.getArray());
        timer.stop();
        // toPrint(array);
        result.setTime(timer.elapsed(TimeUnit.MILLISECONDS));
        result.setAlgorithmName(getClass().getSimpleName());
        result.setArrayType(arrayContainer.getArrayType());
        result.setLenght(arrayContainer.getLenght());
        result.setRun(++runNumber);

        repository.save(result);
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
