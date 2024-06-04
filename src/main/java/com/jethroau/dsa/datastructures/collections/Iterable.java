package com.jethroau.dsa.datastructures.collections;

/**
 * Implementing this interface allows an object to be the target of the "foreach" statement.
 *
 * @param <T> the type of elements returned by the iterator
 */
public interface Iterable<T> {
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    Iterator<T> iterator();
}
