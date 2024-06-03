package com.jethroau.dsa.datastructures;

public interface List<T> {
    void push(T element);         // Adds an element to the end of the list
    T pop();                      // Removes and returns the last element in the list
    void unshift(T element);      // Adds an element to the beginning of the list
    T shift();                    // Removes and returns the first element in the list
    T get(int index);             // Returns the element at the specified position
    T getFirst();                 // Returns the first element in the list
    T getLast();                  // Returns the last elemenat in the list
    int size();                   // Returns the number of elements in the list
    boolean isEmpty();            // Returns true if the list contains no elements
    T removeAt(int index);        // Removes and returns the element at the specified position
    void insertAt(int index, T element);  // Inserts the specified element at the specified position
    boolean contains(T element);  // Returns true if the list contains the specified element
    int indexOf(T element);       // Returns the index of the first occurrence of the specified element
    void clear();                 // Removes all elements from the list
    List<T> subList(int fromIndex, int toIndex);  // Returns a portion of the list
    T set(int index, T element);  // Replaces the element at the specified position with the specified element
    String toString();
}
