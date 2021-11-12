package com.luxoft.datastructures.list;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractListTest {
    private List list;

    @BeforeEach
    public void before(){
        list = getList();
    }

    protected abstract List getList();

        @Test
        public void testAddAndGetValue(){

            list.add("a");
            list.add("b");
            list.add("c");

            assertEquals("a", list.get(0));
            assertEquals("b", list.get(1));
            assertEquals("c", list.get(2));
        }

        @Test
        public void testAddByIndexAndGetValue(){


            list.add("a");
            list.add("b");
            list.add("c");
            list.add("d");
            list.add("e");

            assertEquals("a", list.get(0));
            assertEquals("b", list.get(1));
            assertEquals("c", list.get(2));

            list.add("ddd", 3);

            assertEquals("ddd", list.get(3));
            assertEquals("d", list.get(4));
        }

        @Test
        public void testAddThrowExceptionWhenIndexBiggerThanSize(){


            list.add(1);
            list.add(2);

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                list.add(3, 4);
            });
        }

        @Test
        public void testAddThrowExceptionWhenIndexLessThanZero(){


            list.add(1);
            list.add(2);

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                list.add(3, -1);
            });
        }

        @Test
        public void testAddAndRemoveAndCheckSize(){


            assertEquals(0, list.size());
            list.add(1);
            list.add(2);
            list.add(3);
            assertEquals(3, list.size());
            list.remove(2);
            list.remove(1);
            list.remove(0);
            assertEquals(0, list.size());

        }

        @Test
        public void testRemoveThrowExceptionWhenIndexBiggerThanSize(){


            list.add(1);
            list.add(2);
            list.add(3);
            list.remove(0);
            list.remove(1);

            Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
                list.remove(2);
            });

        }

        @Test
        public void testGetThrowIndexOutOfBoundsExceptionWhenIndexBiggerThanSize(){


            list.add(1);
            list.add(2);

            Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
                list.get(3);
            });
        };

        @Test
        public void testSetAndGet(){


            list.add(0);
            list.add("B");
            list.add(12);

            assertEquals("B", list.get(1));
            list.set("A", 1);
            assertEquals("A", list.get(1));
        }

        @Test
        public void testSetThrowIndexOutOfBoundsExceptionWhenIndexBiggerThanSize(){


            list.add(0);
            list.add("B");

            Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
                list.set("A", 3);
            });

        }

        @Test
        public void testClearlistList(){

            list.add(1);
            list.add(2);
            list.add(3);
            assertEquals(3, list.size());
            list.clear();
            assertEquals(0, list.size());
        }

        @Test
        public void testIsEmptyReturnTrueOnNewList(){

            assertTrue(list.isEmpty());
        }

        @Test
        public void testIsEmptyReturnTrueAfterClear(){

            list.add(1);
            list.add(2);
            assertFalse(list.isEmpty());
            list.clear();
            assertTrue(list.isEmpty());
        }

        @Test
        public void testContainsReturnTrueWhenValueExist(){

            list.add(1);
            assertTrue(list.contains(1));
        }

        @Test
        public void testContainsReturnFalseWhenValueDoesntExist(){

            list.add(1);
            assertFalse(list.contains(10));
        }

        @Test
        public void testContainsThrowIllegalStateExceptionOnEmptyList(){

            Assertions.assertThrows(IllegalStateException.class, ()->{
                list.contains(0);
            });
        }

        @Test
        public void testIndexOfReturnIndexWhenValueExist(){

            list.add("A");
            assertEquals(0, list.indexOf("A"));
            list.add("B", 0);
            assertEquals(0, list.indexOf("B"));
            assertEquals(1, list.indexOf("A"));
        }

        @Test
        public void testIndexOfReturnNegativeOneWhenValueDoesntExist(){

            list.add("A");
            assertEquals(-1, list.indexOf("B"));
        }

        @Test
        public void testIndexOfThrowIllegalStateExceptionWhenListIsEmpty(){


            Assertions.assertThrows(IllegalStateException.class, ()->{
                list.indexOf("A");
            });
        }

        @Test
        public void testLastIndexOf(){

            list.add("A");
            list.add("B");
            list.add("A");
            assertEquals(2, list.lastIndexOf("A"));
        }

        @Test
        public void testLastIndexOfWhenValueDoesNotExist(){

            list.add("A");
            list.add("B");
            assertEquals(-1, list.lastIndexOf("C"));
        }

        @Test
        public void testLastIndexOfOnEmptylist(){


            Assertions.assertThrows(IllegalStateException.class, ()->{
                list.lastIndexOf("A");
            });
        }

        @Test
        public void  testToString(){

            list.add("A");
            list.add("B");
            assertEquals("[A, B]", list.toString());
        }

        @Test
        public void  testToStringThrowIllegalStateExceptionOnEmptylistList(){


            Assertions.assertThrows(IllegalStateException.class, ()->{
                list.toString();
            });
        }

}
