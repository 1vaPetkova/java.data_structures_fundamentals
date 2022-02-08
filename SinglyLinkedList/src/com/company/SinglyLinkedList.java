package com.company;

public class SinglyLinkedList implements LinkedList<Integer> {
    private ListNode head;
    private int size;

    private static class ListNode {
        private Integer value;
        private ListNode next;

        public ListNode(Integer value) {
            this.value = value;
            this.next = null;
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
                currentElement = currentElement.next; // finding the last element
            }
            currentElement.next = lastElement;
        }
        this.size++;
    }

    @Override
    public Integer removeFirst() {
        checkIfEmpty();
        Integer value = this.head.value;
        this.head = this.head.next;
        this.size--;
        return value;
    }

    @Override
    public Integer removeLast() {
        checkIfEmpty();
        if (this.size == 1) {
            Integer value = this.head.value;
            this.head = null;
            this.size--;
            return value;
        } else {
            ListNode lastElement = this.head;
            ListNode previousToLast = this.head;
            while (lastElement.next != null) {
                previousToLast = lastElement;   //finding the last Element
                lastElement = lastElement.next;
            }
            previousToLast.next = null;
            this.size--;
            return lastElement.value;
        }
    }

    @Override
    public Integer getFirst() {
        checkIfEmpty();
        return this.head.value;
    }

    @Override
    public Integer getLast() {
        checkIfEmpty();
        ListNode lastElement = this.head;
        while (lastElement.next != null) {
            lastElement = lastElement.next;
        }
        return lastElement.value;
    }

    @Override
    public Integer getElementAtIndex(int index) {
        checkIfOutOfBounds(index);

        ListNode element = this.head;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private void checkIfOutOfBounds(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException(String.format("The value of M must be within [0, %d)!", this.size));
        }
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty!");
        }
    }

}

