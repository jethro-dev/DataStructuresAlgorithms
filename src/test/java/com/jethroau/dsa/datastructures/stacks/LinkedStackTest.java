package com.jethroau.dsa.datastructures.stacks;

import com.jethroau.dsa.datastructures.collections.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {

    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPeek() {
        Stack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.peek());

        stack.pop();

        assertEquals(1, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new LinkedStack<>();

        assertTrue(stack.isEmpty());

        stack.push(1);

        assertFalse(stack.isEmpty());

        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        Stack<Integer> stack = new LinkedStack<>();

        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.size());

        stack.pop();

        assertEquals(1, stack.size());
    }
}
