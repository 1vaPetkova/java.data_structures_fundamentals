package com.company;

import java.util.Iterator;

public class SinglyLinkedList implements LinkedList<Integer> {
    private ListNode head;
    private int size;


    private static class ListNode {
        private Integer value;
        private ListNode next;

        public ListNode(Integer value) {
            this.value = value;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(Integer element) {
        ListNode firstElement = new ListNode(element);
        firstElement.next = this.head;
        this.head = firstElement;
        this.size++;
    }

    @Override
    public void addLast(Integer element) {
        ListNode lastElement = new ListNode(element);
        if (this.size == 0) {
            this.head = lastElement;
        } else {
            ListNode currentElement = this.head;
            while (currentElement.next != null) {
                currentElement = currentElement.next;
            }
            currentElement.next = lastElement;
        }
        this.size++;

    }

    @Override
    public Integer removeFirst() {
        checkIfEmpty();
        Integer value = this.head.value;
        this.head = null;
        this.size--;
        return value;

    }

    @Override
    public Integer removeLast() {
        return null;
    }

    @Override
    public Integer getFirst() {
        return null;
    }

    @Override
    public Integer getLast() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private ListNode current = head;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public Integer next() {
                Integer value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
