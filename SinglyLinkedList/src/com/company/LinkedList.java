package com.company;

public interface LinkedList<Integer> /*extends Iterable<Integer>*/ {
    void addFirst(Integer element);

    void addLast(Integer element);

    Integer removeFirst();

    Integer removeLast();

    Integer getFirst();

    Integer getLast();

    Integer getElementAtIndex(String m);

    int size();

    boolean isEmpty();
}
