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

    boolean offer(T element);
    T remove();
    T poll();
    T element();
    T peek();
}
