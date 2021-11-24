package com.luxoft.datastructures.list;

import com.luxoft.datastructures.queue.ArrayQueue;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList extends AbstractList {

    private Object[] array;
    private int currentCapacity;

    private void ensureCapacity() {
            currentCapacity = (int) (currentCapacity * 1.5);

        Object[] newArray = new Object[currentCapacity];
        System.arraycopy(array, 0, newArray, 0, size - 1 );
        array = newArray;
    }

    public ArrayList() {
        array = new Object[10];
        currentCapacity = 10;
    }

    public ArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
        currentCapacity = initialCapacity;
    }

    @Override
    public void add(Object value, int index) {
        checkBounds(index);
        if (size == currentCapacity) {
            ensureCapacity();
        }

        if (index<size) {
            System.arraycopy(array, index, array, index + 1, size);
        }
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        checkBounds(index);

        Object removedObject =  array[index];;
        System.arraycopy(array, index+1, array, index, size-index);
        size--;

        return removedObject;
    }

    @Override
    public Object get(int index) {
        checkBounds(index);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        checkBounds(index);
        array[index] = value;
        return array[index];
    }

    @Override
    public void clear() {
        checkIsEmpty();

        for (Object o : array) {
            o = null;
        }

        size = 0;
    }

    @Override
    public int indexOf(Object value) {
        checkIsEmpty();
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        checkIsEmpty();

        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public String toString() {
        checkIsEmpty();

        StringJoiner printedArray = new StringJoiner(", ", "[", "]");

        Iterator iterator = new ArrayList.ArrayListIterator();

        while (iterator.hasNext()) {
            printedArray.add(iterator.next().toString());
        }

        return printedArray.toString();
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public class ArrayListIterator implements Iterator {
        int currentElementIndex = 0;
        int maxCount = size;

        @Override
        public boolean hasNext() {
            return currentElementIndex < maxCount;
        }

        @Override
        public Object next() {
            Object currentElement = array[currentElementIndex];
            currentElementIndex++;
            return currentElement;
        }
    }
}
