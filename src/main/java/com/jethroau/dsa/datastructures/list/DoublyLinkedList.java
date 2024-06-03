package com.jethroau.dsa.datastructures.list;


import com.jethroau.dsa.datastructures.List;

public class DoublyLinkedList<T> implements List<T> {

    // Node class for doubly linked list
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }


    // Get by index
    @Override
    public T get(int idx){
        Node<T> curr = head;
        for(int i = 0; i< idx; i++){
            curr = curr.next;
        }

        return curr.data;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    // push
    @Override
    public void push(T data){
        Node<T> newNode = new Node<>(data);
        if (tail == null) { // Empty list
            head = tail = newNode;
        } else{

            tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        }
        size++;
    }

    // pop
    @Override
    public T pop(){
        if (tail == null) throw new IllegalStateException("List is empty");

        T data = tail.data;
        tail = tail.prev;

        if(tail == null){
            head= null;
        }else{
            tail.next = null;
        }

        size--;
        return data;
    }

    // unshift
    @Override
    public void unshift(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // shift
    @Override
    public T shift(){
        if(isEmpty()){
            throw new RuntimeException("List is empty");
        }
        T data = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }


    // Insert an element at a specific index
    public void insertAt(int index, T data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");

        if (index == 0) {
            unshift(data);
            return;
        }
        if (index == size) {
            push(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    @Override
    public boolean contains(T element) {

        for(Node<T> n = head; n != null; n = n.next){
            if(element.equals(n.data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        for(Node<T> n = head; n != null; n = n.next){
            if(element.equals(n.data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        checkPositionIndex(fromIndex);
        checkPositionIndex(toIndex);
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex cannot be greater than toIndex");
        }
        DoublyLinkedList<T> subList = new DoublyLinkedList<>();
        if (fromIndex == toIndex) {
            return subList; // return an empty sublist
        }
        Node<T> current = getNode(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.push(current.data);
            current = current.next;
        }
        return subList;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");

        Node<T> current = head;

        for(int i = 0; i< index; i++){
            current = current.next;
        }
        T old = current.data;
        current.data = element;

        return old;

    }

    // Remove an element at a specific index
    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        T data = current.data;
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        size--;
        return data;
    }

    // Get the size of the list
    @Override
    public int size() {
        return size;
    }

    // Check if the list is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        Node<T> curr = head;
        StringBuilder sb = new StringBuilder();
        sb.append('[');


        while(curr != null){
            sb.append(curr.data);

            if(curr.next != null){
                sb.append(", ");
            }
            curr = curr.next;
        }

        sb.append(']');

        return sb.toString();
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private Node<T> getNode(int index) {
        Node<T> x;
        if (index < (size >> 1)) {
            x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }
}
