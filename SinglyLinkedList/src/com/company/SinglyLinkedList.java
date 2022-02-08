package com.company;

import java.util.Arrays;

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

    public SinglyLinkedList(String input) {
        this.head = null;
        this.size = 0;
        this.createListOfIntegers(input);
    }

    private void createListOfIntegers(String input) {
        String[] numbers = input.split("\\s+");
        checkIfIntegers(numbers);
        int[] values = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int value : values) {
            addLast(value);
        }
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
    public Integer getElementAtIndex(String mString) {
        checkIfNumberIsAnInteger(mString);
        int m = Integer.parseInt(mString);
        checkIfOutOfBounds(m);
        ListNode element = this.head;
        for (int i = 0; i < this.size - 1 - m; i++) {
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

//    @Override
//    public Iterator<Integer> iterator() {
//        return new Iterator<Integer>() {
//            private ListNode current = head;
//
//            @Override
//            public boolean hasNext() {
//                return current.next != null;
//            }
//
//            @Override
//            public Integer next() {
//                Integer value = current.value;
//                current = current.next;
//                return value;
//            }
//        };
//    }


    private void checkIfOutOfBounds(int m) {
        if (m < 0 || m >= this.size) {
            throw new IllegalArgumentException("The value of M is out of the singly linked list bounds!");
        }
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty!");
        }
    }

    private void checkIfIntegers(String[] numbers) {
        for (String number : numbers) {
            checkIfNumberIsAnInteger(number);
        }
    }

    private void checkIfNumberIsAnInteger(String number) {
        char[] chars = number.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("Please enter valid digits!");
            }
        }
    }

}

