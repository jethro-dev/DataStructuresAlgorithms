package com.jethroau.dsa.datastructures.collections;

/**
 * A SortedSet extended with navigation methods reporting closest matches for given search targets.
 *
 * @param <T> the type of elements maintained by this set
 */
public interface NavigableSet<T> extends SortedSet<T> {
    T lower(T e);
    T floor(T e);
    T ceiling(T e);
    T higher(T e);
    T pollFirst();
    T pollLast();
    NavigableSet<T> descendingSet();
    Iterator<T> descendingIterator();
}
