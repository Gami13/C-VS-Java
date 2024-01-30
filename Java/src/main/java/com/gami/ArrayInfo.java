package com.gami;

/*Class that stores the array, time to sort, and iterations to sort*/
public class ArrayInfo {
    private Integer[] array;
    private long timeToSort;
    private long iterationsToSort;

    public ArrayInfo(Integer[] array, long timeToSort, long iterationsToSort) {
        this.array = array;
        this.timeToSort = timeToSort;
        this.iterationsToSort = iterationsToSort;
    }

    public Integer[] getArray() {
        return array;
    }

    public long getTimeToSort() {
        return timeToSort/1000000;
    }

    public long getIterationsToSort() {
        return iterationsToSort;
    }

    public void saveArrayToFile(String filePath) {
        String text = "";
        text += "Time to sort: " + getTimeToSort() + "ms\n";
        text += "Iterations to sort: " + iterationsToSort + "\n";
        text += "Sorted array: \n";
        text += Utilities.arrayToString(array);
        try {

            Utilities.writeFile(text,filePath);
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }
    }

}
