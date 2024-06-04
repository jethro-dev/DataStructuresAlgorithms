package com.jethroau.dsa.algorithms;

import java.util.Arrays;

public class SelectionSort{

    /**
     * Selection Sort
     * <p>
     * Search through an array and keep track of the minimun value during each iteration.
     * At the end of each iteration, we swap variables.
     * <p>
     * Worst, average, and best time complexity: O(n^2)
     * <p>
     * Space complexity: O(1)
     */
    public static <T extends Comparable<T>> void sort(T[] arr)
    {
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i+1; j<arr.length; j++){
                // find min of remaining list
                if ( arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

    }

    public static void main(String[] args) {
        Integer[] arr = {64,25,12,22,11};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
