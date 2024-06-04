package com.jethroau.dsa.datastructures.collections;

import com.jethroau.dsa.datastructures.collections.Collection;

/**
 * An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.
 *
 * @param <T> the type of elements in this list
 */
public interface List<T> extends Collection<T> {
    T get(int index);
    T set(int index, T element);
    void add(int index, T element);
    T remove(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    ListIterator<T> listIterator();
    ListIterator<T> listIterator(int index);
}
