package com.jethroau.dsa.datastructures.collections;

/**
 * A collection that contains no duplicate elements. More formally, sets contain no pair of elements {@code e1} and {@code e2} such that {@code e1.equals(e2)}, and at most one null element.
 *
 * @param <T> the type of elements maintained by this set
 */
public interface Set<T> extends Collection<T> {

    // No new methods; this interface simply refines the contracts of the methods inherited from Collection.
}
