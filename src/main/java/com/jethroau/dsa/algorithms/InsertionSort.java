package com.jethroau.dsa.algorithms;

import java.util.Arrays;

public class InsertionSort{

    /**
     * Insertion Sort
     * <p>
     * Insertion sort is a simple sorting algorithm that works by building a sorted array one element at a time. It is considered an “in-place” sorting algorithm, meaning it doesn’t require any additional memory space beyond the original array.
     * <p>
     * Worst and average time complexity: O(n^2)
     * <p>
     * Best time complexity: O(n)
     * <p>
     * Space complexity: O(1)
     */
    public static <T extends Comparable<T>> void sort(T[] arr)
    {
        for(int i = 1; i< arr.length; i++){
            T temp = arr[i];
            int j = i-1;

            while(j >= 0 && arr[j].compareTo(temp) > 0){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {64,25,12,22,11};
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
