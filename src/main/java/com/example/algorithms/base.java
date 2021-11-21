package com.example.algorithms;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public abstract class base {
    private Stopwatch timer;

    public base() {
        timer = Stopwatch.createUnstarted();
    }

    protected abstract void run();

    public Long calculateTime() {
        timer.start();
        run();
        timer.stop();
        return timer.elapsed(TimeUnit.NANOSECONDS);
    }
}