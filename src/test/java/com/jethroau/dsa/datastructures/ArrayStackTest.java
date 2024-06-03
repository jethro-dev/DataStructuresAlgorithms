package com.jethroau.dsa.datastructures;

import com.jethroau.dsa.datastructures.stacks.ArrayStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayStack<>();
    }

    @Test
    void testPush() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeek() {
        stack.push(1);
        assertEquals(1, stack.peek());
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    void testPopEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void testPeekEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.peek();
        });
        assertEquals("Stack is empty", exception.getMessage());
    }
}
