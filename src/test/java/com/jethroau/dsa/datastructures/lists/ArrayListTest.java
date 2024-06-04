package com.jethroau.dsa.datastructures.lists;

import com.jethroau.dsa.datastructures.collections.Iterator;
import com.jethroau.dsa.datastructures.collections.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
    }

    @Test
    public void testAdd() {
        list.add("apple");
        list.add("banana");
        assertEquals(2, list.size());
        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
    }

    @Test
    public void testAddAtIndex() {
        list.add("apple");
        list.add("banana");
        list.add(1, "orange");
        assertEquals(3, list.size());
        assertEquals("apple", list.get(0));
        assertEquals("orange", list.get(1));
        assertEquals("banana", list.get(2));
    }

    @Test
    public void testGet() {
        list.add("apple");
        list.add("banana");
        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
    }

    @Test
    public void testSet() {
        list.add("apple");
        list.add("banana");
        assertEquals("apple", list.set(0, "orange"));
        assertEquals("orange", list.get(0));
    }

    @Test
    public void testRemove() {
        list.add("apple");
        list.add("banana");
        assertEquals("apple", list.remove(0));
        assertEquals(1, list.size());
        assertEquals("banana", list.get(0));
    }

    @Test
    public void testContains() {
        list.add("apple");
        list.add("banana");
        assertTrue(list.contains("apple"));
        assertFalse(list.contains("orange"));
    }

    @Test
    public void testIndexOf() {
        list.add("apple");
        list.add("banana");
        list.add("apple");
        assertEquals(0, list.indexOf("apple"));
        assertEquals(1, list.indexOf("banana"));
    }

    @Test
    public void testLastIndexOf() {
        list.add("apple");
        list.add("banana");
        list.add("apple");
        assertEquals(2, list.lastIndexOf("apple"));
        assertEquals(1, list.lastIndexOf("banana"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("apple");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add("apple");
        assertEquals(1, list.size());
    }

    @Test
    public void testIterator() {
        list.add("apple");
        list.add("banana");
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("apple", iterator.next());
        assertEquals("banana", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
