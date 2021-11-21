package com.example.algorithms;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public abstract class base {
    private Stopwatch timer;

    public base() {
        timer = Stopwatch.createUnstarted();
    }

    protected abstract Integer[] run(Integer[] array);

    public Long calculateTime(Integer[] array) {
        toPrint(array);
        timer.start();
        run(array);
        timer.stop();
        toPrint(array);
        return timer.elapsed(TimeUnit.NANOSECONDS);
    }

    private void toPrint(Integer[] array) {
        String text = "[";
        for (int i = 0; i < array.length-1; i++) {
            text += array[i] + ", ";
        }
        text += array[array.length-1] + "]";
        System.out.println(text);
    }
}
