package com.luxoft.datastructures.queue;

public interface Queue {
    void enqueue(Object value);

    Object dequeue();

    int size();

    boolean isEmpty();
    
    boolean contains(Object object);

    void clear();

    Object pick(int index);

    Object front();

    Object rear();
}
