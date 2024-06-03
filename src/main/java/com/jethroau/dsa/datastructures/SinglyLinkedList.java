package com.jethroau.dsa.datastructures;

import com.jethroau.dsa.datastructures.List;

public class SinglyLinkedList<T> implements List<T>{
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void push(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }

    @Override
    public void unshift(T element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public T shift() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        Node current = getNode(index);
        return current.data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T removeAt(int index) {
        checkElementIndex(index);
        if (index == 0) {
            return shift();
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }

    @Override
    public void insertAt(int index, T element) {
        checkPositionIndex(index);
        if (index == 0) {
            unshift(element);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(element);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    @Override
    public boolean contains(T element) {
        Node current = head;
        while (current != null) {
            if (element.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (element.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        checkPositionIndex(fromIndex);
        checkPositionIndex(toIndex);
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex cannot be greater than toIndex");
        }
        SinglyLinkedList<T> subList = new SinglyLinkedList<>();
        Node current = getNode(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.push(current.data);
            current = current.next;
        }
        return subList;
    }

    @Override
    public T set(int index, T element) {
        checkElementIndex(index);
        Node node = getNode(index);
        T oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    // Helper methods

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
