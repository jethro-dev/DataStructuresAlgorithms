package com.jethroau.dsa.datastructures.lists;

import com.jethroau.dsa.datastructures.collections.Iterator;
import com.jethroau.dsa.datastructures.collections.List;
import com.jethroau.dsa.datastructures.collections.Deque;
import com.jethroau.dsa.datastructures.collections.ListIterator;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>, Deque<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T e) {
        Node<T> newNode = new Node<>(e);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T e) {
        add(e);
    }

    @Override
    public boolean offerFirst(T e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(T e) {
        addLast(e);
        return true;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        T data = head.data;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    @Override
    public T pollFirst() {
        if (isEmpty()) return null;
        return removeFirst();
    }

    @Override
    public T pollLast() {
        if (isEmpty()) return null;
        return removeLast();
    }

    @Override
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return tail.data;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) return null;
        return head.data;
    }

    @Override
    public T peekLast() {
        if (isEmpty()) return null;
        return tail.data;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        Node<T> n = tail;
        while (n != null) {
            if (n.data.equals(o)) {
                if (n.prev != null) {
                    n.prev.next = n.next;
                } else {
                    head = n.next;
                }

                if (n.next != null) {
                    n.next.prev = n.prev;
                } else {
                    tail = n.prev;
                }
                size--;
                return true;
            }
            n = n.prev;
        }
        return false;
    }

    @Override
    public void push(T e) {
        addFirst(e);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new DescendingLinkedListIterator();
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T set(int index, T element) {
        T oldData = getNode(index).data;
        getNode(index).data = element;
        return oldData;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<T> n = getNode(index);
            n.prev.next = newNode;
            newNode.prev = n.prev;
            newNode.next = n;
            n.prev = newNode;
            size++;
        }
    }

    @Override
    public T remove(int index) {
        Node<T> n = getNode(index);
        T data = n.data;
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }
        size--;
        return data;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> n = head;
        int index = 0;
        while (n != null) {
            if (n.data.equals(o)) {
                return index;
            }
            n = n.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> n = tail;
        int index = size - 1;
        while (n != null) {
            if (n.data.equals(o)) {
                return index;
            }
            n = n.prev;
            index--;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new LinkedListListIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new LinkedListListIterator(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public boolean offer(T element) {
        return add(element);
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> n = head;
        while (n != null) {
            if (n.data.equals(o)) {
                if (n.prev != null) {
                    n.prev.next = n.next;
                } else {
                    head = n.next;
                }

                if (n.next != null) {
                    n.next.prev = n.prev;
                } else {
                    tail = n.prev;
                }
                size--;
                return true;
            }
            n = n.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> n = head;
        while (n != null) {
            if (n.data.equals(o)) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null && size == 0;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private class LinkedListIterator implements Iterator<T> {
        protected Node<T> current;
        protected Node<T> lastReturned;

        LinkedListIterator() {
            current = head;
            lastReturned = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = current;
            current = current.next;
            return lastReturned.data;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            Node<T> nextNode = lastReturned.next;
            Node<T> prevNode = lastReturned.prev;

            if (prevNode == null) {
                head = nextNode;
            } else {
                prevNode.next = nextNode;
                lastReturned.prev = null;
            }

            if (nextNode == null) {
                tail = prevNode;
            } else {
                nextNode.prev = prevNode;
                lastReturned.next = null;
            }

            size--;
            lastReturned = null;
        }
    }

    private class LinkedListListIterator extends LinkedListIterator implements ListIterator<T> {
        private int nextIndex;

        LinkedListListIterator(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            current = (index == size) ? null : getNode(index);
            nextIndex = index;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (current == null) {
                current = tail;
            } else {
                current = current.prev;
            }
            lastReturned = current;
            nextIndex--;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void set(T e) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            lastReturned.data = e;
        }

        @Override
        public void add(T e) {
            lastReturned = null;

            if (current == null) {
                addLast(e);
            } else {
                Node<T> newNode = new Node<>(e);
                Node<T> prevNode = current.prev;

                newNode.next = current;
                current.prev = newNode;

                if (prevNode == null) {
                    head = newNode;
                } else {
                    prevNode.next = newNode;
                    newNode.prev = prevNode;
                }

                size++;
            }
            nextIndex++;
        }
    }

    private class DescendingLinkedListIterator implements Iterator<T> {
        private Node<T> current;
        private Node<T> lastReturned;

        DescendingLinkedListIterator() {
            current = tail;
            lastReturned = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = current;
            current = current.prev;
            return lastReturned.data;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            Node<T> nextNode = lastReturned.next;
            Node<T> prevNode = lastReturned.prev;

            if (prevNode == null) {
                head = nextNode;
            } else {
                prevNode.next = nextNode;
                lastReturned.prev = null;
            }

            if (nextNode == null) {
                tail = prevNode;
            } else {
                nextNode.prev = prevNode;
                lastReturned.next = null;
            }

            size--;
            lastReturned = null;
        }
    }
}
