package com.jethroau.dsa.datastructures;

public interface Queue<T> {
    void enqueue(T element);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}
