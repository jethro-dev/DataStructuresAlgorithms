package com.jethroau.dsa.datastructures.queues;

import com.jethroau.dsa.datastructures.collections.Iterator;
import com.jethroau.dsa.datastructures.collections.Queue;
import com.jethroau.dsa.datastructures.lists.LinkedList;

public class LinkedQueue<T> implements Queue<T> {
    private LinkedList<T> list;

    public LinkedQueue() {
        list = new LinkedList<>();
    }

    @Override
    public boolean offer(T e) {
        list.addLast(e);
        return true;
    }

    @Override
    public T poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public T remove() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public T element() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean add(T e) {
        return offer(e);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
