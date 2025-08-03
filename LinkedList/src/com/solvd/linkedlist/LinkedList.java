package com.solvd.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);

        if (head == null) {
            head = node;
        } else 
        {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
        size++;
    }
    
    public void addTo(int index, T value) {
        checkIndex(index);
        
        if (index == size) {
            add(value);
            return;
        }

        Node<T> newNode = new Node<>(value);

        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (size == 0) tail = newNode;
            size++;
        }
        else {
        Node<T> current = findNode(index);
        Node<T> prevNode = current.prev;
        newNode.next = current;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        current.prev = newNode;
        }
        size++; 
    }

    public T get(int index) {
        return findNode(index).value;
    }

    public void set(int index, T value) {
        findNode(index).value = value;
    }

    public T remove(int index) {
        Node<T> node = findNode(index);
        T removedValue = node.value;

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        size--;
        return removedValue;
    }

    public int size() {
        return size;
    }

    private Node<T> findNode(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be non-negative. Your index: " + index);
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index is outside of size("+size+"). Your index: " + index);
        }
    }
    
    public void addAll(Iterable<? extends T> collection) {
        for (T item : collection) {
            add(item);
        }
    }
    public boolean containsChar(char c) {
        Node<T> current = head;
        boolean found = false;

        System.out.println("Elements containing '" + c + "':");

        while (current != null) {
            String str = String.valueOf(current.value);
            if (str.indexOf(c) != -1) {
                System.out.println("- " + current.value);
                found = true;
            }
            current = current.next;
        }

        return found;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
