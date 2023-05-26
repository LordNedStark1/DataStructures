package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.MyQueue;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    MyQueue<String> queue;
    @BeforeEach
    public void beforeEach(){
        queue = new MyQueue<>(10);
    }

    @Test
    public void testAddingAndRemovingFromQueue(){
        MyQueue<String> queue = new MyQueue<>(10);
        queue.enqueue("money");
        queue.enqueue("shop");
        assertEquals(10, queue.size());
        assertEquals("money", queue.dequeue());
    }
    @Test
    public void testAddRemoveAndAddingToQueue(){
        queue.enqueue("money");
        queue.enqueue("shop");

        assertEquals("money", queue.dequeue());

        queue.enqueue("shoe");
        queue.enqueue("house");
        queue.enqueue("company");

        assertEquals("shop", queue.dequeue());

        queue.enqueue("contact");
        queue.enqueue("dubia");
        queue.enqueue("shell");

        assertEquals("shoe", queue.dequeue());
        assertEquals("house", queue.dequeue());
    }
    @Test
    public void testAddDeleteAndAddToCapacityBehaviourOfQueue(){
        MyQueue<String> queue = new MyQueue<>(5);

        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        queue.enqueue("forth");
        queue.enqueue("fifth");

        assertEquals("first", queue.dequeue());
        assertEquals("second", queue.dequeue());
        assertEquals("third", queue.dequeue());

        queue.enqueue("money");
        queue.enqueue("dubia");
        queue.enqueue("shell");

        assertFalse(queue.isEmpty());

        assertEquals("forth", queue.dequeue());
        assertEquals("fifth", queue.dequeue());
        assertEquals("dubia", queue.dequeue());
        assertEquals("shell", queue.dequeue());

        assertTrue(queue.isEmpty());
    }
}
