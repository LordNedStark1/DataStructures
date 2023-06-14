package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.MyQueue;
import queue.MyQueueOne;

import static org.junit.jupiter.api.Assertions.*;

public class QueueOneTest {
    MyQueue<String> queue;
    @BeforeEach
    public void beforeEach(){
        queue = new MyQueueOne<>();
    }
//    MyQueue queue = new MyQueue();
    @Test
    public void testQueueSize(){

        assertEquals(0,queue.size());
    }
    @Test
    public void testEnqueueMethod(){

        queue.enqueue("manager");
        assertEquals(1, queue.size());
    }
    @Test
    public void testDequeueMethod(){
        queue.enqueue("manager");
        queue.enqueue("house");
        queue.enqueue("land");
        assertEquals(3, queue.size());

        assertEquals("manager", queue.dequeue());
        assertEquals(2, queue.size());
    }
    @Test
    public void testDequeue(){
        queue.enqueue("manager");
        queue.enqueue("house");
        queue.enqueue("land");
        assertEquals(3, queue.size());

        assertEquals("manager", queue.dequeue());
        assertEquals("house", queue.dequeue());
        assertEquals(1, queue.size());
    }
    @Test
    public void testPeekMethod(){
        queue.enqueue("money");
        queue.enqueue("shop");

        assertEquals("money", queue.peek());
        assertEquals("money", queue.dequeue());

        assertEquals("shop", queue.peek());
        assertEquals(1, queue.size());
        assertEquals("shop", queue.dequeue());
    }
    @Test
    public void testEnqueueTwice(){
        queue.enqueue("house");
        queue.enqueue("monster");
        assertEquals("house", queue.peek());


        assertEquals("house", queue.dequeue());

        assertEquals("monster", queue.peek());
        queue.enqueue("shoe");
        assertEquals("monster", queue.peek());
        queue.enqueue("school");
        queue.enqueue("company");

        assertEquals("monster", queue.peek());
    }
    @Test
    public void testAddRemoveFromQueue(){
        queue.enqueue("money");
        queue.enqueue("shop");


        assertEquals("money", queue.dequeue());

        queue.enqueue("shoe");
        queue.enqueue("house");
        queue.enqueue("company");

        assertEquals("shop", queue.peek());
        assertEquals(4, queue.size());
        assertEquals("shop", queue.dequeue());


        queue.enqueue("contact");
        queue.enqueue("dubia");
        queue.enqueue("shell");

        assertEquals("shoe", queue.dequeue());
        assertEquals("house", queue.dequeue());
    }
    @Test
    public void testIsEmptyMethod(){
      assertTrue(queue.isEmpty());
      queue.enqueue("Shoulder");
      assertFalse(queue.isEmpty());
      queue.dequeue();
      assertTrue(queue.isEmpty());
    }
}
