package com.company;

public interface LinkedList<E> {
    void addFirst(E element);

    void addLast(E element);

    E removeFirst();

    E removeLast();

    E getFirst();

    E getLast();

    E getElementAtIndex(int m);

    int size();

    boolean isEmpty();
}
