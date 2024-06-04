package com.jethroau.dsa.datastructures.trees;

import com.jethroau.dsa.datastructures.collections.Tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root ;
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(T data) {
        root = insertRecursive(root,data);
    }

    private Node<T> insertRecursive(Node<T> node, T data){
        if(node == null){
            return new Node<>(data);
        }

        if(data.compareTo(node.data) < 0){
            node.left = insertRecursive(node.left, data);
        }else if (data.compareTo(node.data) > 0) {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    @Override
    public boolean search(T data) {
        return searchRecursive(root,data);
    }

    private boolean searchRecursive(Node<T> node, T data){
        if(node == null){
            return false;
        }
        if(data.compareTo(node.data) == 0){
            return true;
        }
        return data.compareTo(node.data) < 0
                ? searchRecursive(node.left,data)
                : searchRecursive(node.right,data);
    }

    @Override
    public void delete(T data) {
        root = deleteRecursive(root,data);
    }

    private Node<T> deleteRecursive(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = deleteRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteRecursive(node.right, data);
        } else {
            // Node to be deleted found

            // Nodes with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.data = findMin(node.right);

            // Delete the inorder successor
            node.right = deleteRecursive(node.right, node.data);
        }

        return node;
    }

    private T findMin(Node<T> right) {
        return right.data;
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
