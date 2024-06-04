package com.jethroau.dsa.datastructures.lists;

import com.jethroau.dsa.datastructures.collections.List;
import com.jethroau.dsa.datastructures.collections.Deque;
import com.jethroau.dsa.datastructures.collections.Iterator;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void testRemove() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(1, deque.remove());
        assertEquals(1, deque.size());
        assertEquals(2, deque.remove());
        assertEquals(0, deque.size());
        assertThrows(NoSuchElementException.class, deque::remove);
    }

    @Test
    public void testElement() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(1, deque.element());
        deque.remove();
        assertEquals(2, deque.element());
        deque.remove();
        assertThrows(NoSuchElementException.class, deque::element);
    }

    @Test
    public void testPoll() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(1, deque.poll());
        assertEquals(1, deque.size());
        assertEquals(2, deque.poll());
        assertNull(deque.poll());
    }


    @Test
    public void testAddFirst() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);

        assertEquals(2, deque.getFirst());
        assertEquals(1, deque.getLast());
    }

    @Test
    public void testAddLast() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(1, deque.getFirst());
        assertEquals(2, deque.getLast());
    }

    @Test
    public void testOfferFirst() {
        Deque<Integer> deque = new LinkedList<>();
        assertTrue(deque.offerFirst(1));
        assertTrue(deque.offerFirst(2));

        assertEquals(2, deque.getFirst());
        assertEquals(1, deque.getLast());
    }

    @Test
    public void testOfferLast() {
        Deque<Integer> deque = new LinkedList<>();
        assertTrue(deque.offerLast(1));
        assertTrue(deque.offerLast(2));

        assertEquals(1, deque.getFirst());
        assertEquals(2, deque.getLast());
    }

    @Test
    public void testRemoveFirst() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);

        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.removeFirst());
        assertThrows(NoSuchElementException.class, deque::removeFirst);
    }

    @Test
    public void testRemoveLast() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(2, deque.removeLast());
        assertEquals(1, deque.removeLast());
        assertThrows(NoSuchElementException.class, deque::removeLast);
    }

    @Test
    public void testPollFirst() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);

        assertEquals(2, deque.pollFirst());
        assertEquals(1, deque.pollFirst());
        assertNull(deque.pollFirst());
    }

    @Test
    public void testPollLast() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(2, deque.pollLast());
        assertEquals(1, deque.pollLast());
        assertNull(deque.pollLast());
    }

    @Test
    public void testGetFirst() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(1, deque.getFirst());
    }

    @Test
    public void testGetLast() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(2, deque.getLast());
    }

    @Test
    public void testPeekFirst() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(1, deque.peekFirst());
        deque.pollFirst();
        assertEquals(2, deque.peekFirst());
        deque.pollFirst();
        assertNull(deque.peekFirst());
    }

    @Test
    public void testPeekLast() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(2, deque.peekLast());
        deque.pollLast();
        assertEquals(1, deque.peekLast());
        deque.pollLast();
        assertNull(deque.peekLast());
    }

    @Test
    public void testRemoveFirstOccurrence() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(1);

        assertTrue(deque.removeFirstOccurrence(1));
        assertEquals(2, deque.size());
        assertEquals(2, deque.getFirst());
        assertEquals(1, deque.getLast());
    }

    @Test
    public void testRemoveLastOccurrence() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(1);

        assertTrue(deque.removeLastOccurrence(1));
        assertEquals(2, deque.size());
        assertEquals(1, deque.getFirst());
        assertEquals(2, deque.getLast());
    }

    @Test
    public void testPush() {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);

        assertEquals(2, deque.getFirst());
        assertEquals(1, deque.getLast());
    }

    @Test
    public void testPop() {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);

        assertEquals(2, deque.pop());
        assertEquals(1, deque.pop());
        assertThrows(NoSuchElementException.class, deque::pop);
    }

    @Test
    public void testAdd() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testRemoveByIndex() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    public void testRemoveByValue() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.remove(Integer.valueOf(2)));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    public void testGetSet() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.get(1));
        list.set(1, 4);
        assertEquals(4, list.get(1));
    }

    @Test
    public void testIndexOf() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        assertEquals(1, list.indexOf(2));
        assertEquals(3, list.lastIndexOf(2));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    public void testContains() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }

    @Test
    public void testIsEmpty() {
        List<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        List<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testIterator() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testDescendingIterator() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Iterator<Integer> iterator = deque.descendingIterator();
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }
}
