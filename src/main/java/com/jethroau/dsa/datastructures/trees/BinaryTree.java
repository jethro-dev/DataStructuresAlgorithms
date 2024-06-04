package com.jethroau.dsa.datastructures.trees;

import com.jethroau.dsa.datastructures.collections.Queue;
import com.jethroau.dsa.datastructures.collections.Stack;
import com.jethroau.dsa.datastructures.collections.Tree;
import com.jethroau.dsa.datastructures.lists.LinkedList;
import com.jethroau.dsa.datastructures.queues.LinkedQueue;
import com.jethroau.dsa.datastructures.stacks.LinkedStack;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

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
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            return;
        }

        LinkedQueue<Node<T>> queue = new LinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            if (node.left == null) {
                node.left = newNode;
                break;
            } else {
                queue.add(node.left);
            }
            if (node.right == null) {
                node.right = newNode;
                break;
            } else {
                queue.add(node.right);
            }
        }
    }


    @Override
    public boolean search(T data) {
        return searchRecursive(root,data);
    }

    private boolean searchRecursive(Node<T> node,T data){
        // DFS - In-order traversal
        if(node == null){
            return false;
        }
        if(node.data.equals(data)){
            return true;
        }
        return searchRecursive(node.left, data) || searchRecursive(node.right, data);
    }

    @Override
    public void delete(T data) {
        deleteNode(root, data);
    }

    private void deleteNode(Node<T> root, T data) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.data.equals(data)) {
                this.root = null;
            }
            return;
        }

        Queue<Node<T>> q = new LinkedList<Node<T>>();
        q.add(root);
        Node<T> temp = null, keyNode = null;

        // Do level order traversal until we find key and last node.
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.data.equals(data)) {
                keyNode = temp;
            }

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }

        if (keyNode != null) {
            T x = temp.data;
            keyNode.data = x;
            deleteDeepest(root, temp);
        }
    }

    private void deleteDeepest(Node<T> root, Node<T> delNode) {
        Queue<Node<T>> q = new LinkedList<Node<T>>();
        q.add(root);
        Node<T> temp;

        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp == delNode) {
                temp = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
        }
    }

    private Node<T> findSmallest(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public String inOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversalRecursive(root, sb);
        return sb.toString().trim();
    }

    private void inOrderTraversalRecursive(Node<T> node, StringBuilder sb) {
        if (node != null) {
            inOrderTraversalRecursive(node.left, sb);
            sb.append(node.data).append(" ");
            inOrderTraversalRecursive(node.right, sb);
        }
    }

    @Override
    public String preOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        preOrderTraversalRecursive(root, sb);
        return sb.toString().trim();
    }

    private void preOrderTraversalRecursive(Node<T> node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data).append(" ");
            preOrderTraversalRecursive(node.left, sb);
            preOrderTraversalRecursive(node.right, sb);
        }
    }

    @Override
    public String postOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        postOrderTraversalRecursive(root, sb);
        return sb.toString().trim();
    }

    private void postOrderTraversalRecursive(Node<T> node, StringBuilder sb) {
        if (node != null) {
            postOrderTraversalRecursive(node.left, sb);
            postOrderTraversalRecursive(node.right, sb);
            sb.append(node.data).append(" ");
        }
    }

}
