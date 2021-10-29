package com.luxoft.datastructures.queue;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static  org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @Test
    public void testEnqueueAndDequeueAndCheckSize(){
        ArrayQueue testArray = new ArrayQueue();
        assertTrue(testArray.isEmpty());

        testArray.enqueue("Hello");
        testArray.enqueue("Hi");

        assertEquals(2, testArray.size());
        assertEquals("Hello", testArray.dequeue());
        assertEquals("Hi", testArray.dequeue());
        assertTrue(testArray.isEmpty());
    }

    @Test
    public void testEnqueueAndPick(){
        ArrayQueue testArray = new ArrayQueue();
        testArray.enqueue("Hello");
        testArray.enqueue("Hi");

        assertEquals(2, testArray.size());
        assertEquals("Hello", testArray.pick(0));
        assertEquals("Hi", testArray.pick(1));
        assertEquals(2, testArray.size());
    }

    @Test
    public void testDequeueOnEmptyQueue(){
        ArrayQueue testArray = new ArrayQueue();

        Assertions.assertThrows(IllegalStateException.class, ()->{
            testArray.dequeue();
        });

    }

    @Test
    public void testIsEmptyOnNewQueue(){
        ArrayQueue testArray = new ArrayQueue();
        assertTrue(testArray.isEmpty());
    }

    @Test
    public void testEnqueueOnCapacityOutOfBounds(){
        ArrayQueue testQueue = new ArrayQueue(2);
        testQueue.enqueue(1);
        testQueue.enqueue(2);

        Assertions.assertThrows(IllegalStateException.class, ()->{
            testQueue.enqueue(3);
        });
    }

    @Test
    public void testPickOnEmptyQueue(){
        ArrayQueue testQueue = new ArrayQueue(2);

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            testQueue.pick(0);
        });
    }

    @Test
    public void testContainsOnEmptyQueue(){
        ArrayQueue testQueue = new ArrayQueue(2);

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            testQueue.contains(0);
        });
    }

    @Test
    public void testIsEmptyReturnFalseOnQueueWithData(){

        ArrayQueue testArray = new ArrayQueue();

        testArray.enqueue(1);
        testArray.enqueue(2);

        assertFalse(testArray.isEmpty());

    }

    @Test
    public void testClear(){

        ArrayQueue testArray = new ArrayQueue();

        testArray.enqueue(1);
        testArray.enqueue(2);
        assertEquals(2, testArray.size());

        testArray.clear();
        assertTrue(testArray.isEmpty());

    }
}
