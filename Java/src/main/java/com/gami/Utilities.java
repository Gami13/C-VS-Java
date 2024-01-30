package com.gami;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Vector;

public class Utilities {
    private static long iterations = 0;

    public static void main(String[] args) {
    }

    public static String readFile(String filePath) {
        StringBuilder output = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                output.append(data).append("\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return output.toString();
    }
    public static void writeFile(String contents,String path)  throws IOException
    {
        byte[] strToBytes = contents.getBytes();

        File yourFile = new File(path);
        System.out.println(yourFile.getAbsolutePath());
        yourFile.createNewFile(); // if file already exists will do nothing
        FileOutputStream oFile = new FileOutputStream(yourFile, false);
        oFile.write(strToBytes);
    }

    public static Integer[] NLSStringToArray(String input) {
        Vector<Integer> numbers = new Vector<Integer>();
        String[] lines = input.split("\n");
        for (String line : lines) {
            numbers.add(Integer.parseInt(line));
        }
        return numbers.toArray(new Integer[0]);


    }

    public static Integer[] bubbleSort(Integer[] input) {
        int n = input.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (input[j - 1] > input[j]) {
                    //swap elements
                    temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                }

            }
        }
        return input;
    }

    public static ArrayInfo bubbleSortWithInfo(Integer[] input) {
        int n = input.length;
        int temp = 0;

        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            if(i%1000==0)
            {
                System.out.println("Iteration: "+i);
            }
            for (int j = 1; j < (n - i); j++) {
                if (input[j - 1] > input[j]) {
                    iterations++;
                    temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                }

            }
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        long outputIterations = iterations;
        iterations = 0;
        return new ArrayInfo(input, timeElapsed, outputIterations);
    }

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
                iterations++;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    public static ArrayInfo quickSortWithInfo(Integer[] arr, int begin, int end) {

        long startTime = System.nanoTime();
        quickSort(arr, begin, end);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        long outputIterations = iterations;
        iterations = 0;
        return new ArrayInfo(arr, timeElapsed, outputIterations);
    }


    public static ArrayInfo selectionSortWithInfo(Integer[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                    iterations++;
                }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        long outputIterations = iterations;
        iterations = 0;
        return new ArrayInfo(arr, timeElapsed, outputIterations);
    }
    public static String arrayToString(Integer[] arr)
    {
        StringBuilder output = new StringBuilder();
        for (Integer integer : arr) {
            output.append(integer).append("\n");
        }
        return output.toString();
    }

}