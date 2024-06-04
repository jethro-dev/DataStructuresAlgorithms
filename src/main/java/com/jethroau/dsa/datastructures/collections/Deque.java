package com.jethroau.dsa.datastructures.collections;

/**
 * A linear collection that supports element insertion and removal at both ends. Deque is short for "double-ended queue" and is pronounced "deck".
 *
 * @param <T> the type of elements held in this collection
 */
public interface Deque<T> extends Queue<T> {
    void addFirst(T e);
    void addLast(T e);
    boolean offerFirst(T e);
    boolean offerLast(T e);
    T removeFirst();
    T removeLast();
    T pollFirst();
    T pollLast();
    T getFirst();
    T getLast();
    T peekFirst();
    T peekLast();
    boolean removeFirstOccurrence(Object o);
    boolean removeLastOccurrence(Object o);
    void push(T e);
    T pop();
    Iterator<T> descendingIterator();
}
