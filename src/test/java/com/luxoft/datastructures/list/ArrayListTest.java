package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static  org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void testAddByIndex(){
        ArrayList array = new ArrayList(5);

        array.add("a");
        array.add("b");
        array.add("c");

        array.add("d", 1);
        assertEquals("d", array.get(1));
        assertEquals("b", array.get(2));
        assertEquals("c", array.get(3));
    }

    @Test
    public void testAddByIndexBiggerThanArraySize(){
        ArrayList array = new ArrayList(5);

        array.add(1);
        array.add(2);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.add(3, 4);
        });
    }

    @Test
    public void testAddAndRemoveAndCheckSize(){
        ArrayList array = new ArrayList(3);

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
    public void testRemoveByIndexOutOfBounds(){
        ArrayList array = new ArrayList(3);

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
    public void testAddAndGetValue(){
        ArrayList array = new ArrayList(5);

        array.add(1);
        array.add(2);

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
    }

    @Test
    public void testGetOnIndexOutOfBounds(){
        ArrayList array = new ArrayList(5);

        array.add(1);
        array.add(2);

        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
            array.get(3);
        });
    };

    @Test
    public void testSetAndGet(){
        ArrayList array = new ArrayList(3);

        array.add(0);
        array.add("B");
        array.add(12);

        assertEquals("B", array.get(1));
        array.set("A", 1);
        assertEquals("A", array.get(1));
    }

    @Test
    public void testSetOnIndexOutOfBounds(){
        ArrayList array = new ArrayList(3);

        array.add(0);
        array.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
            array.set("A", 3);
        });

    }

    @Test
    public void testClearArrayList(){
        ArrayList array = new ArrayList(3);
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals(3, array.size());
        array.clear();
        assertEquals(0, array.size());
    }

    @Test
    public void testIsEmptyOnNewArray(){
        ArrayList array = new ArrayList();
        assertTrue(array.isEmpty());
    }

    @Test
    public void testIsEmptyAfterClear(){
        ArrayList array = new ArrayList();
        array.add(1);
        array.add(2);
        assertFalse(array.isEmpty());
        array.clear();
        assertTrue(array.isEmpty());
    }

    @Test
    public void testContains(){
        ArrayList array = new ArrayList();
        array.add(1);
        array.add(2);
        assertTrue(array.contains(1));
        assertFalse(array.contains(3));
    }


    @Test
    public void testContainsOnEmptyArray(){
        ArrayList array = new ArrayList();
        Assertions.assertThrows(IllegalStateException.class, ()->{
           array.contains(0);
        });
    }

    @Test
    public void testIndexOfValue(){
        ArrayList array = new ArrayList();
        array.add("A");
        assertEquals(0, array.indexOf("A"));
        array.add("B", 0);
        assertEquals(0, array.indexOf("B"));
        assertEquals(1, array.indexOf("A"));
    }

    @Test
    public void testIndexOfWhenValueDoesntExist(){
        ArrayList array = new ArrayList();
        array.add("A");
        assertEquals(-1, array.indexOf("B"));
    }

    @Test
    public void testIndexOfOnEmptyArray(){
        ArrayList array = new ArrayList();

        Assertions.assertThrows(IllegalStateException.class, ()->{
            array.indexOf("A");
        });
    }


    @Test
    public void testLastIndexOf(){
        ArrayList array = new ArrayList();
        array.add("A");
        array.add("B");
        array.add("A");
        assertEquals(2, array.lastIndexOf("A"));
    }

    @Test
    public void testLastIndexOfWhenValueDoesNotExist(){
        ArrayList array = new ArrayList();
        array.add("A");
        array.add("B");
        assertEquals(-1, array.lastIndexOf("C"));
    }

    @Test
    public void testLastIndexOfOnEmptyArray(){
        ArrayList array = new ArrayList();

        Assertions.assertThrows(IllegalStateException.class, ()->{
            array.lastIndexOf("A");
        });
    }

    @Test
    public void  testToString(){
        ArrayList array = new ArrayList();
        array.add("A");
        array.add("B");
        assertEquals("[A, B]", array.toString());
    }

    @Test
    public void  testToStringOnEmptyArrayList(){
        ArrayList array = new ArrayList();

        Assertions.assertThrows(IllegalStateException.class, ()->{
            array.toString();
        });
    }
}

