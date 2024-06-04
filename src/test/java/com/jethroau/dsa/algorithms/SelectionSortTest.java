package com.jethroau.dsa.algorithms;

import com.jethroau.dsa.datastructures.trees.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    @Test
    public void testSort() {

        Integer[] arr = {64,25,12,22,11};
        SelectionSort.sort(arr);
        assertEquals(arr[0],11);
        assertEquals(arr[1],12);
        assertEquals(arr[2],22);
        assertEquals(arr[3],25);
        assertEquals(arr[4],64);
        System.out.println("Sorted array");

    }

}
