package com.jethroau.dsa.datastructures.trees;

import com.jethroau.dsa.datastructures.collections.Tree;

public class BinaryTree<T> implements Tree<T> {

    private static class Node<T>{
        Node<T> left;
        Node<T> right;
        T data;

        Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;

    public BinaryTree(){
        root = null;
    }

    @Override
    public void insert(T data) {

    }

    @Override
    public boolean search(T data) {
        return false;
    }

    @Override
    public void delete(T data) {

    }

    @Override
    public void inOrderTraversal() {

    }

    @Override
    public void preOrderTraversal() {

    }

    @Override
    public void postOrderTraversal() {

    }




}
