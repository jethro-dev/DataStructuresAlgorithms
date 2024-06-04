package com.jethroau.dsa.algorithms;

import com.jethroau.dsa.datastructures.trees.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    @Test
    public void testSort() {

        Integer[] arr = {64,25,12,22,11};
        InsertionSort.sort(arr);
        assertEquals(arr[0],11);
        assertEquals(arr[1],12);
        assertEquals(arr[2],22);
        assertEquals(arr[3],25);
        assertEquals(arr[4],64);

        Integer[] arr2= { 64, 34, 25, 12, 22, 11, 90 };
        InsertionSort.sort(arr2);
        assertEquals(arr2[0],11);
        assertEquals(arr2[1],12);
        assertEquals(arr2[2],22);
        assertEquals(arr2[3],25);
        assertEquals(arr2[4],34);
        assertEquals(arr2[5],64);
        assertEquals(arr2[6],90);

    }

}
