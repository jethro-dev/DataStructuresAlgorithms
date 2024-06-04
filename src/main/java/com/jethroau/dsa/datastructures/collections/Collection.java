package com.jethroau.dsa.datastructures.collections;

import java.util.Iterator;

public interface Collection<T> extends Iterable<T>{

    boolean add(T element);
    boolean remove(Object o);
    boolean contains(Object o);
    int size();
    void clear();
    boolean isEmpty();
}