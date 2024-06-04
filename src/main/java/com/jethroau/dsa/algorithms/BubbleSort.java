package com.jethroau.dsa.algorithms;

import java.util.Arrays;

public class BubbleSort{

    /**
     * Bubble Sort
     * <p>
     * Iterate through the array repeatedly, comparing adjacent pairs of elements and swapping them if they are in the wrong order. Repeat until the array is fully sorted.
     * <p>
     * Worst and average time complexity: O(n^2)
     * <p>
     * Best time complexity (when array is already sorted): O(n)
     * <p>
     * Space complexity: O(1)
     * <p>
     * Advantages: Simple implementation, stable sorting algorithm.
     * <p>
     * Disadvantages: Inefficient for large datasets
     */
    public static <T extends Comparable<T>> void sort(T[] arr)
    {

        for(int i = 0; i< arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            System.out.println("insider: " + Arrays.toString(arr));

            }
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void main(String[] args) {
        Integer[] arr = { 1,2,3,4 };
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
