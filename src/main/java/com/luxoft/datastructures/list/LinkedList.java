package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList extends AbstractList {

    private Node head;
    private Node tail;

    @Override
    public void add(Object value, int index) {

        checkBounds(index);

        Node newNode = new Node(value);

        if (size == 0) {

            head = tail = newNode;

        } else if (index == 0) {

            head.prev = newNode;
            newNode.next = head;
            head = newNode;

        } else if (index == size) {

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        } else {

            Node currentNode = getNode(index);

            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;

        }

        size++;
    }

    @Override
    public Object remove(int index) {
        checkBounds(index);
        checkIsEmpty();

        Node removedNode = null;

        if (size == 1) {
            removedNode = head;
            clear();
            return removedNode;
        } else if (index == 0) {
            removedNode = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            removedNode = tail;
            tail = removedNode.prev;
            tail.next = null;
        } else {
            Node currentNode = getNode(index);

            removedNode = currentNode.next;
            currentNode.next = removedNode.next;
            removedNode.next.prev = currentNode;
        }
        size--;

        return removedNode.value;
    }

    @Override
    public Object get(int index) {
        checkBounds(index);
        int counter = 0;
        Node currentNode = getNode(index);
        return currentNode.value;
    }

    @Override
    public Object set(Object value, int index) {
        checkBounds(index);

        int counter = 0;
        Node currentNode = head;
        while (counter < size) {
            if (counter == index) {
                currentNode.value = value;
                return currentNode.value;
            }
            currentNode = currentNode.next;
            counter++;
        }
        return null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        checkIsEmpty();

        int counter = 0;

        Iterator iterator = new LinkedList.LinkedListIterator();
        while (iterator.hasNext()) {
            if (value.equals(iterator.next())) {
                return counter;
            }
            counter++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        checkIsEmpty();

        int counter = 0;
        int result = -1;

        Iterator iterator = new LinkedList.LinkedListIterator();
        while (iterator.hasNext()) {
            if (value.equals(iterator.next())) {
                result = counter;
            }
            counter++;
        }

        return result;
    }

    @Override
    public String toString() {
        checkIsEmpty();

        StringJoiner printedArray = new StringJoiner(", ", "[", "]");
        Node currentNode = head;

        Iterator iterator = new LinkedListIterator();

        while (iterator.hasNext()) {
            printedArray.add(iterator.next().toString());
        }

        return printedArray.toString();
    }

    private Node getNode(int index) {
        checkBounds(index);
        Node currentNode = head;

        if (index == 0) {
            currentNode = head;
        } else if (index == size - 1) {
            currentNode = tail;
        } else if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator {
        private int maxCount = size;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            Node o = getNode(index);
            index++;
            return o.value;
        }

    }
}




