package com.jethroau.dsa.datastructures.collections;

import java.util.Iterator;

public interface Collection<T> {
    /**
     * Adds an element to the collection.
     * @param element the element to add
     * @return true if the element was added successfully
     */
    boolean add(T element);

    /**
     * Removes a single instance of the specified element from this collection, if it is present.
     * @param o the element to remove
     * @return true if the element was removed successfully
     */
    boolean remove(Object o);

    /**
     * Returns true if this collection contains the specified element.
     * @param o the element to check for presence
     * @return true if the collection contains the element
     */
    boolean contains(Object o);

    /**
     * Returns the number of elements in this collection.
     * @return the number of elements in the collection
     */
    int size();

    /**
     * Returns true if this collection contains no elements.
     * @return true if the collection is empty
     */
    boolean isEmpty();

    /**
     * Returns an iterator over the elements in this collection.
     * @return an Iterator over the elements in the collection
     */
    Iterator<T> iterator();
}