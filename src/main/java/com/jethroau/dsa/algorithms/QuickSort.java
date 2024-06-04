package com.jethroau.dsa.algorithms;

import java.util.Arrays;

public class QuickSort {

    /**
     * Quick Sort
     * <p>
     * Divides the array into two subarrays, recursively sorts them, and combines them.
     * <p>
     * Worst time complexity: O(n^2)
     * <p>
     * Best\Average time complexity: O(nlogn)
     * <p>
     * Space complexity: O(n)
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        sortRecursive(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void sortRecursive(T[] arr, int left, int right) {
        if (left >= right) return; // base case

        int pivot = partition(arr, left, right);
        sortRecursive(arr, left, pivot - 1);
        sortRecursive(arr, pivot + 1, right);

    }

    private static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j].compareTo(arr[right]) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, right);
        return i;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int left, int right) {
        T temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public static void main(String[] args) {
        Integer[] arr = {64, 25, 12, 22, 11};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        Integer[] arr2 = {8, 2, 5, 3, 9, 4, 7, 6, 1};
        QuickSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
