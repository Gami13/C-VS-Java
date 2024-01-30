package com.gami;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        String fileContents = Utilities.readFile("C:\\numbers.txt");

        Integer[] numbers = Utilities.NLSStringToArray(fileContents);
        Integer[] numbers2 = Utilities.NLSStringToArray(fileContents);
        Integer[] numbers3 = Utilities.NLSStringToArray(fileContents);
        System.out.println("STARTING SORTING 1");
        ArrayInfo arrayInfo = Utilities.bubbleSortWithInfo(numbers);
        System.out.println("STARTING SORTING 2");
        ArrayInfo arrayInfo2 = Utilities.quickSortWithInfo(numbers2, 0, numbers2.length - 1);
        System.out.println("STARTING SORTING 3");
        ArrayInfo arrayInfo3 = Utilities.selectionSortWithInfo(numbers3);
        System.out.println("Bubble sort time: " + arrayInfo.getTimeToSort() + "ms" + " Iterations: " + arrayInfo.getIterationsToSort());
        System.out.println("Quick sort time: " + arrayInfo2.getTimeToSort() + "ms" + " Iterations: " + arrayInfo2.getIterationsToSort());
        System.out.println("Selection sort time: " + arrayInfo3.getTimeToSort() + "ms" + " Iterations: " + arrayInfo3.getIterationsToSort());
        arrayInfo.saveArrayToFile("C:\\bubble.txt");
        arrayInfo2.saveArrayToFile("C:\\quick.txt");
        arrayInfo3.saveArrayToFile("C:\\selection.txt");

    }
}