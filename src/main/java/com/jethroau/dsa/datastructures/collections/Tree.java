package com.jethroau.dsa.datastructures.collections;


public interface Tree<T> {
    void insert(T data);
    boolean search(T data);
    void delete(T data);
    String inOrderTraversal();
    String preOrderTraversal();
    String postOrderTraversal();
}
