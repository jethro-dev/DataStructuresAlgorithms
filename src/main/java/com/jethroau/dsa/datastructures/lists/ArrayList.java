package com.jethroau.dsa.datastructures.lists;

import com.jethroau.dsa.datastructures.collections.Iterator;
import com.jethroau.dsa.datastructures.collections.List;
import com.jethroau.dsa.datastructures.collections.ListIterator;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<T>  implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(T element){
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    @Override
    public void add(int index, T element) {
        checkPositionIndex(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements,index,elements,index+1, size-index);
        elements[index] = element;
        size++;
    }

    @Override
    public T get(int index){
        checkPositionIndex(index);

        return elements[index];
    }

    @Override
    public T set(int index, T element){
        checkPositionIndex(index);
        T oldData = elements[index];
        elements[index] = element;

        return oldData;
    }

    @Override
    public boolean remove(Object o) {
        for (int index = 0; index < size; index++) {
            if (o.equals(elements[index])) {
                remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        checkPositionIndex(index);
        T oldElement = elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldElement;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if(o.equals(elements[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if(o.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
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

    private class ArrayListIterator implements Iterator<T> {
        private int cursor;
        private int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            return elements[cursor++];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }

}
