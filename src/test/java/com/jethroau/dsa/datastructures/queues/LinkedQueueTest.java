package com.jethroau.dsa.datastructures.queues;

import com.jethroau.dsa.datastructures.collections.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {

    @Test
    public void testOfferAndPoll() {
        Queue<Integer> queue = new LinkedQueue<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertNull(queue.poll());
    }

    @Test
    public void testPeek() {
        Queue<Integer> queue = new LinkedQueue<>();

        queue.offer(1);
        queue.offer(2);

        assertEquals(1, queue.peek());

        queue.poll();

        assertEquals(2, queue.peek());
        queue.poll();
        assertNull(queue.peek());
    }

    @Test
    public void testIsEmpty() {
        Queue<Integer> queue = new LinkedQueue<>();

        assertTrue(queue.isEmpty());

        queue.offer(1);

        assertFalse(queue.isEmpty());

        queue.poll();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSize() {
        Queue<Integer> queue = new LinkedQueue<>();

        assertEquals(0, queue.size());

        queue.offer(1);
        queue.offer(2);

        assertEquals(2, queue.size());

        queue.poll();

        assertEquals(1, queue.size());
    }

    @Test
    public void testElement() {
        Queue<Integer> queue = new LinkedQueue<>();

        queue.offer(1);
        queue.offer(2);

        assertEquals(1, queue.element());

        queue.poll();

        assertEquals(2, queue.element());

        queue.poll();

        assertThrows(IllegalStateException.class, () -> {
            queue.element();
        });
    }

    @Test
    public void testRemove() {
        Queue<Integer> queue = new LinkedQueue<>();

        queue.offer(1);
        queue.offer(2);

        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());

        assertThrows(IllegalStateException.class, () -> {
            queue.remove();
        });
    }
}
