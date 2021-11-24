package com.luxoft.datastructures.list;

public abstract class AbstractList implements List {
    protected int size = 0;

    public void add(Object value) {
        add(value, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected void checkBounds(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can't be less than zero");
        } else if (index > size) {
            throw new IndexOutOfBoundsException("Index can't be bigger than list size. Current list size is" + size + ". Your index is: " + index);
        }
    }

    protected void checkIsEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }
    }
}
