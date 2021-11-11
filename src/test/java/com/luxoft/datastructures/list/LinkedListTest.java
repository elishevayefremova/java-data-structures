package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static  org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void testAddAndGetValue(){
        LinkedList array = new LinkedList();

        array.add("a");
        array.add("b");
        array.add("c");

        assertEquals("a", array.get(0));
        assertEquals("b", array.get(1));
        assertEquals("c", array.get(2));
    }

    @Test
    public void testAddByIndexAndGetValue(){
        LinkedList array = new LinkedList();

        array.add("a");
        array.add("b");
        array.add("c");

        assertEquals("a", array.get(0));
        assertEquals("b", array.get(1));
        assertEquals("c", array.get(2));

        array.add("d", 2);

        assertEquals("d", array.get(2));
        assertEquals("c", array.get(3));
    }

    @Test
    public void testAddThrowExceptionWhenIndexBiggerThanSize(){
        LinkedList array = new LinkedList();

        array.add(1);
        array.add(2);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.add(3, 4);
        });
    }

    @Test
    public void testAddThrowExceptionWhenIndexLessThanZero(){
        LinkedList array = new LinkedList();

        array.add(1);
        array.add(2);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.add(3, -1);
        });
    }

    @Test
    public void testAddAndRemoveAndCheckSize(){
        LinkedList array = new LinkedList();

        assertEquals(0, array.size());
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals(3, array.size());
        array.remove(2);
        array.remove(1);
        array.remove(0);
        assertEquals(0, array.size());

    }

    @Test
    public void testRemove_ThrowException_WhenIndexBiggerThanSize(){
        LinkedList array = new LinkedList();

        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(0);
        array.remove(1);

        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
            array.remove(2);
        });

    }

    @Test
    public void testGetThrowIndexOutOfBoundsExceptionWhenIndexBiggerThanSize(){
        LinkedList array = new LinkedList();

        array.add(1);
        array.add(2);

        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
            array.get(3);
        });
    };

    @Test
    public void testSetAndGet(){
        LinkedList array = new LinkedList();

        array.add(0);
        array.add("B");
        array.add(12);

        assertEquals("B", array.get(1));
        array.set("A", 1);
        assertEquals("A", array.get(1));
    }

    @Test
    public void testSetThrowIndexOutOfBoundsExceptionWhenIndexBiggerThanSize(){
        LinkedList array = new LinkedList();

        array.add(0);
        array.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
            array.set("A", 3);
        });

    }

    @Test
    public void testClearArrayList(){
        LinkedList array = new LinkedList();
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals(3, array.size());
        array.clear();
        assertEquals(0, array.size());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewList(){
        LinkedList array = new LinkedList();
        assertTrue(array.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueAfterClear(){
        LinkedList array = new LinkedList();
        array.add(1);
        array.add(2);
        assertFalse(array.isEmpty());
        array.clear();
        assertTrue(array.isEmpty());
    }

    @Test
    public void testContainsReturnTrueWhenValueExist(){
        LinkedList array = new LinkedList();
        array.add(1);
        assertTrue(array.contains(1));
    }

    @Test
    public void testContainsReturnFalseWhenValueDoesntExist(){
        LinkedList array = new LinkedList();
        array.add(1);
        assertFalse(array.contains(10));
    }

    @Test
    public void testContainsThrowIllegalStateExceptionOnEmptyList(){
        LinkedList array = new LinkedList();
        Assertions.assertThrows(IllegalStateException.class, ()->{
            array.contains(0);
        });
    }

    @Test
    public void testIndexOfReturnIndexWhenValueExist(){
        LinkedList array = new LinkedList();
        array.add("A");
        assertEquals(0, array.indexOf("A"));
        array.add("B", 0);
        assertEquals(0, array.indexOf("B"));
        assertEquals(1, array.indexOf("A"));
    }

    @Test
    public void testIndexOfReturnNegativeOneWhenValueDoesntExist(){
        LinkedList array = new LinkedList();
        array.add("A");
        assertEquals(-1, array.indexOf("B"));
    }

    @Test
    public void testIndexOfThrowIllegalStateExceptionWhenListIsEmpty(){
        LinkedList array = new LinkedList();

        Assertions.assertThrows(IllegalStateException.class, ()->{
            array.indexOf("A");
        });
    }


    @Test
    public void testLastIndexOf(){
        LinkedList array = new LinkedList();
        array.add("A");
        array.add("B");
        array.add("A");
        assertEquals(2, array.lastIndexOf("A"));
    }

    @Test
    public void testLastIndexOfWhenValueDoesNotExist(){
        LinkedList array = new LinkedList();
        array.add("A");
        array.add("B");
        assertEquals(-1, array.lastIndexOf("C"));
    }

    @Test
    public void testLastIndexOfOnEmptyArray(){
        LinkedList array = new LinkedList();

        Assertions.assertThrows(IllegalStateException.class, ()->{
            array.lastIndexOf("A");
        });
    }

    @Test
    public void  testToString(){
        LinkedList array = new LinkedList();
        array.add("A");
        array.add("B");
        assertEquals("[A, B]", array.toString());
    }

    @Test
    public void  testToStringThrowIllegalStateExceptionOnEmptyArrayList(){
        LinkedList array = new LinkedList();

        Assertions.assertThrows(IllegalStateException.class, ()->{
            array.toString();
        });
    }
}

