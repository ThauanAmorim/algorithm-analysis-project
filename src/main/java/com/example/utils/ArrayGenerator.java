package com.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.example.entities.ArrayContainer;

public class ArrayGenerator {
    private Random random = new Random();

    public ArrayContainer ordered(int quantity) {
        Integer[] array = new Integer[quantity];
        int count = 2;
        int lastNumber = 0;

        for(int i = 0; i < quantity; i++) {
            array[i] = random.nextInt(count) + (lastNumber + 1);
            lastNumber = array[i];
            count++;
        }
        
        return new ArrayContainer("ordered", quantity, array);
    }

    public ArrayContainer inverselyOrdered(int quantity) {
        ArrayContainer arrayContainer = ordered(quantity);
        Integer[] array = arrayContainer.getArray();

        List<Integer> list = Arrays.asList(array);
        Collections.reverse(list);
        array = (Integer[]) list.toArray();
        arrayContainer.setArray(array);
        arrayContainer.setArrayType("Inversely Ordered");

        return arrayContainer;
    }

    public ArrayContainer random(int quantity) {
        Integer[] array = new Integer[quantity];
        int maxValue = (quantity * 10) + 1;
        
        for(int i = 0; i < quantity; i++) {
            array[i] = random.nextInt(maxValue);
        }

        repeaterNumberValidate(array, new ArrayList<Integer>());

        return new ArrayContainer("random", quantity, array);
    }

    public ArrayContainer almostOrdered(int quantity, float orderedPorcent) {
        ArrayContainer arrayContainer = ordered(quantity);
        Integer[] array = arrayContainer.getArray();

        int exchangesNumber = (int) (quantity - (quantity * (orderedPorcent / 100)));
        int firstPosition;
        int secondPosition;
        int aux;

        if(exchangesNumber % 2 != 0) {
            --exchangesNumber;

            int index = 0;
            do {
                index = random.nextInt(quantity-3) +1;
            } while (array[index]+1 == array[index+1]);
            
            if(index == quantity-1) {
                aux = array[index-1];
                array[index-1] = array[index];
                array[index] = aux;
            } else {
                int number = 0;
                do {
                    number = random.nextInt((array[index+2] - array[index+1])) + (array[index+1] + 2);
                } while (number == array[index]);
                array[index] = number;
            }
        }

        if(exchangesNumber <= 0)
            return new ArrayContainer("almost Ordered - " + orderedPorcent + "%", quantity, array);

        for(int i = 0; i < exchangesNumber / 2; i++) {
            firstPosition = random.nextInt(quantity);
            do {
                secondPosition = random.nextInt(quantity);

            } while (secondPosition == firstPosition);

            aux = array[firstPosition];
            array[firstPosition] = array[secondPosition];
            array[secondPosition] = aux;
        }
        return new ArrayContainer("almost Ordered - " + orderedPorcent + "%", quantity, array);
    }

    private void repeaterNumberValidate(Integer[] array, List<Integer> indexRepeater) {
        for(int i = 0; i < array.length -1; i++) {
            for(int j = i +1; j < array.length; j++){
                if (array[j] == array[i]) {
                    indexRepeater.add(j);
                }
            }
        }

        if(!indexRepeater.isEmpty()) {
            for(Integer index : indexRepeater) {
                array[index] = random.nextInt((array.length * 10) + 1);
            }
            indexRepeater.clear();
            repeaterNumberValidate(array, indexRepeater);
        }
    }
}
