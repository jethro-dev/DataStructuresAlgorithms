package com.jethroau.dsa.datastructures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void testPush() {
        list.push(1);
        list.push(2);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testPop() {
        list.push(1);
        list.push(2);
        assertEquals(2, list.pop());
        assertEquals(1, list.pop());
        assertTrue(list.isEmpty());
    }

    @Test
    void testUnshift() {
        list.unshift(1);
        list.unshift(2);
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void testShift() {
        list.unshift(1);
        list.unshift(2);
        assertEquals(2, list.shift());
        assertEquals(1, list.shift());
        assertTrue(list.isEmpty());
    }

    @Test
    void testGet() {
        list.push(1);
        list.push(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testGetFirst() {
        list.push(1);
        list.push(2);
        assertEquals(1, list.getFirst());
    }

    @Test
    void testGetLast() {
        list.push(1);
        list.push(2);
        assertEquals(2, list.getLast());
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.push(1);
        assertEquals(1, list.size());
        list.push(2);
        assertEquals(2, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.push(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testRemoveAt() {
        list.push(1);
        list.push(2);
        list.push(3);
        assertEquals(2, list.removeAt(1));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testInsertAt() {
        list.push(1);
        list.push(3);
        list.insertAt(1, 2);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testContains() {
        list.push(1);
        list.push(2);
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
    }

    @Test
    void testIndexOf() {
        list.push(1);
        list.push(2);
        list.push(3);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(3));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    void testClear() {
        list.push(1);
        list.push(2);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testSubList() {
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        List<Integer> sublist = list.subList(1, 3);
        assertEquals(2, sublist.size());
        assertEquals(2, sublist.get(0));
        assertEquals(3, sublist.get(1));
    }

    @Test
    void testSubListInvalidIndices() {
        list.push(1);
        list.push(2);
        list.push(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(-1, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(1, 5));
        assertThrows(IllegalArgumentException.class, () -> list.subList(3, 2));
    }

    @Test
    void testSubListEmpty() {
        List<Integer> sublist = list.subList(0, 0);
        assertTrue(sublist.isEmpty());
    }
}
