package com.jethroau.dsa.datastructures.collections;

import java.util.Comparator;

/**
 * A Set that further provides a total ordering on its elements.
 *
 * @param <T> the type of elements maintained by this set
 */
public interface SortedSet<T> extends Set<T> {
    Comparator<? super T> comparator();
    SortedSet<T> subSet(T fromElement, T toElement);
    SortedSet<T> headSet(T toElement);
    SortedSet<T> tailSet(T fromElement);
    T first();
    T last();
}
