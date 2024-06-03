package com.jethroau.dsa.datastructures.collections;

import java.util.NoSuchElementException;

/**
 * A collection designed for holding elements prior to processing.
 * Besides basic {@link Collection} operations, queues provide additional insertion, extraction, and inspection operations.
 * Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either null or false, depending on the operation).
 *
 * @param <T> the type of elements held in this collection
 */
public interface Queue<T> extends Collection<T> {

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally preferable to {@link #add}, which can fail to insert an element only by throwing an exception.
     *
     * @param element the element to add
     * @return {@code true} if the element was added to this queue, else {@code false}
     */
    boolean offer(T element);

    /**
     * Retrieves and removes the head of this queue. This method differs from {@link #poll()} only in that it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    T remove();

    /**
     * Retrieves and removes the head of this queue, or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    T poll();

    /**
     * Retrieves, but does not remove, the head of this queue. This method differs from {@link #peek()} only in that it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    T element();

    /**
     * Retrieves, but does not remove, the head of this queue, or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    T peek();
}
