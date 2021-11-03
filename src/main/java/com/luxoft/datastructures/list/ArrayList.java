package com.luxoft.datastructures.list;

import com.luxoft.datastructures.queue.ArrayQueue;

public class ArrayList implements List {

    private Object[] array;
    private int size = 0;
    private int currentCapacity;

    public ArrayList(){
        array = new Object[10];
        currentCapacity = 10;
    }

    public ArrayList(int initialCapacity){
        array = new Object[initialCapacity];
        currentCapacity = initialCapacity;
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if (index > size){
            throw new IndexOutOfBoundsException("Index is bigger than array capacity");
        };

        if (size == currentCapacity) {
            currentCapacity = (int) (currentCapacity * 1.5);
        }
        Object[] newArray = new Object[currentCapacity];

        for (int i = 0; i < array.length; i++) {
            if (i < index){
                newArray[i] = array[i];
            } else if (i==index){
                newArray[i] = value;
            } else{
                newArray[i] = array[i-1];
            }
        }
        array = newArray;
        size++;
    }

    @Override
    public Object remove(int index) {

        int counter = 0;

        if (index > size){
            throw new IndexOutOfBoundsException("Index is bigger than array capacity");
        };

        Object[] newArray = new Object[currentCapacity];
        Object removedObject = null;

        for (int i = 0; i < array.length; i++) {
            if ((index < i) || (index > i)){
                newArray[counter] = array[i];
                counter++;
            } else {
                removedObject = array[i];
            }
        }
        array = newArray;
        size--;

        return removedObject;
    }

    @Override
    public Object get(int index) {
        if (index>size){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (index > size){
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        array[index] = value;

        return array[index];
    }

    @Override
    public void clear() {
        for (Object o : array){
            o = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        if (isEmpty()){
            throw new IllegalStateException("ArrayList is empty.");
        }

        for (Object o : array) {
            if (value.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if (isEmpty()){
            throw new IllegalStateException("ArrayList is empty.");
        }
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (isEmpty()){
            throw new IllegalStateException("ArrayList is empty.");
        }
        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])){
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public String toString(){
        if (isEmpty()){
            throw new IllegalStateException("ArrayList is empty.");
        }
        String printedArray = "[";
        for (int i = 0; i<size-1; i++) {
            printedArray += array[i] + ", ";
        }
        printedArray += array[size-1];
        printedArray += "]";

        return printedArray;
    }

}
