package com.luxoft.datastructures.list;

import java.util.StringJoiner;

public class LinkedList implements List{

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {

        if (index<0){
            throw new IndexOutOfBoundsException("Index can't be less than zero");
        } else if ( index>size){
            throw new IndexOutOfBoundsException("Index can't be bigger than list size. Current list size is" + size + ". Your index is: " + index);
        }

        Node newNode = new Node(value);

        if (size == 0) {

            head = tail = newNode;

        } else if (index == 0) {

            head.prev = newNode;
            newNode.next = head;
            head = newNode;

        } else if (index == size){

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        } else {

            Node currentNode = head;
            int counter = 0;

            while (counter != index){
                currentNode = currentNode.next;
                counter++;
            }

            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;

        }

        size++;
    }

    @Override
    public Object remove(int index) {
        if (index<0){
            throw new IndexOutOfBoundsException("Index can't be less than zero");
        } else if ( index>=size){
            throw new IndexOutOfBoundsException("Index can't be bigger than list size. Current list size is" + size + ". Your index is: " + index);
        } else if (isEmpty()){
            throw new IllegalStateException("List is empty.");
        }

        Node removedNode = null;

        if (size == 1){
            removedNode = head;
            clear();
            return removedNode;
        } else if (index == 0) {
            removedNode = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1){
            removedNode = tail;
            tail = removedNode.prev;
            tail.next = null;
        } else {
            Node currentNode = head;
            int counter = 0;

            while (counter != index - 1) {
                currentNode = currentNode.next;
                counter++;
            }
            removedNode = currentNode.next;

            currentNode.next = removedNode.next;
            removedNode.next.prev = currentNode;
        }
        size--;

        return removedNode;
    }

    @Override
    public Object get(int index) {
        if (index<0){
            throw new IndexOutOfBoundsException("Index can't be less than zero");
        } else if ( index>size){
            throw new IndexOutOfBoundsException("Index can't be bigger than list size. Current list size is" + size + ". Your index is: " + index);
        }
        int counter = 0;
        Node currentNode = head;
        while(counter<size){
            if (counter<index){
                currentNode = currentNode.next;
            } else if (counter == index){
                return currentNode.value;
            }
            counter++;
        }
        return null;
    }

    @Override
    public Object set(Object value, int index) {
        if (index<0){
            throw new IndexOutOfBoundsException("Index can't be less than zero");
        } else if ( index>size){
            throw new IndexOutOfBoundsException("Index can't be bigger than list size. Current list size is" + size + ". Your index is: " + index);
        }

        int counter = 0;
        Node currentNode = head;
        while(counter<size){
            if (counter == index){
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
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0 ? true : false;
    }

    @Override
    public boolean contains(Object value) {
        if (isEmpty()){
            throw new IllegalStateException("List is empty.");
        }

        int counter = 0;
        Node currentNode = head;
        while(counter<size){
            if (value.equals(currentNode.value)){
                return true;
            }
            currentNode = currentNode.next;
            counter++;
        }

        return false;
    }

    @Override
    public int indexOf(Object value) {
        if (isEmpty()){
            throw new IllegalStateException("List is empty.");
        }

        int counter = 0;
        Node currentNode = head;
        while(counter<size){
            if (value.equals(currentNode.value)){
                return counter;
            }
            currentNode = currentNode.next;
            counter++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (isEmpty()){
            throw new IllegalStateException("List is empty.");
        }

        int counter = 0;
        int result = -1;
        Node currentNode = head;
        while(counter<size){
            if (value.equals(currentNode.value)){
                result = counter;
            }
            currentNode = currentNode.next;
            counter++;
        }

        return result;
    }

    @Override
    public String toString(){
        if (isEmpty()){
            throw new IllegalStateException("ArrayList is empty.");
        }

        StringJoiner printedArray = new StringJoiner(", ", "[", "]");
        Node currentNode = head;

        int counter = 0;
        while(counter<size){
            printedArray.add(currentNode.value.toString());
            currentNode = currentNode.next;
            counter++;
        }

        return printedArray.toString();
    }
}
