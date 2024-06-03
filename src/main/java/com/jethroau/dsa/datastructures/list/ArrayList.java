package com.jethroau.dsa.datastructures.list;

import com.jethroau.dsa.datastructures.List;

import java.util.Arrays;

public class ArrayList<T>  implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void push(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        T data = elementData(size - 1);
        elements[--size] = null; // clear to let GC do its work
        return data;
    }

    @Override
    public void unshift(T element) {
        ensureCapacity(size + 1);
        System.arraycopy(elements,0,elements,1,size);
        elements[0] = element;
        size++;
    }

    @Override
    public T shift() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        T data = elementData(0);
        System.arraycopy(elements,1,elements,0,size-1);
        elements[--size] = null;
        return data;
    }

    @Override
    public T get(int index) {
        return elementData(index);
    }

    @Override
    public T getFirst() {
        return elementData(0);
    }

    @Override
    public T getLast() {
        return elementData(size-1);
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
        checkPositionIndex(index);

        T oldData = elementData(index);
        int numMoved = size - index - 1; // Calculate the number of elements to be moved
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved); // Shift elements left
        }
        elements[--size] = null;
        return oldData;
    }

    @Override
    public void insertAt(int index, T element) {
        checkPositionIndex(index);
        ensureCapacity(index+1);
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean contains(T element) {

        for (int i = 0; i < size; i++){
            if(element.equals(elementData(i))){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++){
            if(element.equals(elementData(i))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        checkPositionIndex(fromIndex);
        checkPositionIndex(toIndex);

        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex cannot be greater than toIndex");
        }

        List<T> subList = new ArrayList<T>();
        for(int i = fromIndex; i < toIndex; i++){
            subList.push(elementData(i));
        }

        return subList;

    }

    @Override
    public T set(int index, T element) {
        checkPositionIndex(index);
        T oldValue = elementData(index);
        elements[index] = element;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    private T elementData(int index) {
        return (T) elements[index];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

}
