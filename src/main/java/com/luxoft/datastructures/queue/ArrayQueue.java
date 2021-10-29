package com.luxoft.datastructures.queue;

public class ArrayQueue implements Queue{

    private Object[] arrayQueue;
    private int arraySize;

    public ArrayQueue(){
        arrayQueue = new Object[10];
    }

    public ArrayQueue(int size){
        arrayQueue = new Object[size];
    }

    @Override
    public void enqueue(Object value) {
        if ( arraySize < arrayQueue.length ) {
            arrayQueue[arraySize] = value;
            arraySize++;
        }else {
            throw new IllegalStateException("Array size is out of bounds");
        }
    }

    @Override
    public Object dequeue() {

        if (arraySize != 0) {
            Object dequeuedElement = arrayQueue[0];

            for (int i = 0; i < arrayQueue.length - 1; i++) {
                arrayQueue[i] = arrayQueue[i + 1];
            }

            arraySize--;

            return dequeuedElement;

        }

        throw new IllegalStateException("Queue is empty!");


    }

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public boolean isEmpty() {
        if (arraySize == 0) {
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean contains(Object searchedObject) {
        if (isEmpty() == false) {
            for (Object object : arrayQueue) {
                if (searchedObject.equals(object)) {
                    return true;
                }
            }
            return false;
        } else {
            throw new IllegalArgumentException("Array is Empty");
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < arrayQueue.length; i++) {
            arrayQueue[i] = null;
        }

        arraySize = 0;
    }

    @Override
    public Object pick(int index) {
        if ((isEmpty() == false) && (index < arraySize)) {
            return arrayQueue[index];
        } else throw new IllegalArgumentException("Picked index is out of bounds;");
    }

    @Override
    public Object front() {
        return null;
    }

    @Override
    public Object rear() {
        return null;
    }
}
