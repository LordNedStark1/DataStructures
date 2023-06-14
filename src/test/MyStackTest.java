package test;

import customExceptions.MyStackOverFlowException;
import customExceptions.MyStackUnderFlowException;
import org.junit.jupiter.api.Test;
import stack.MyStack;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyStackTest {
    MyStack<String> stack = new MyStack<>();

    @Test
    public void firstTestForSizeMethod(){
        assertEquals(0, stack.size());
    }
    @Test
    public void TestPushMethod(){
        stack.push("pushed");
        assertEquals(1, stack.size());
    }
    @Test
    public void TestPeekMethod(){
        stack.push("pushed");
        assertEquals("pushed", stack.peek());
    }
    @Test
    public void poppingStackWithOnlyOneElement(){
        assertEquals(0, stack.size());

        stack.push("one");
        assertEquals(1, stack.size());

        assertEquals("one", stack.pop());

        assertEquals(0, stack.size());
    }
    @Test
    public void multiplePopTest(){
        stack.push("objectToPush1");
        stack.push("secondObjectPushed");
        assertEquals("secondObjectPushed", stack.peek());

        stack.push("pushed");
        assertEquals("pushed", stack.peek());

        assertEquals("pushed", stack.pop());
        assertEquals("secondObjectPushed", stack.peek());

        stack.push("afterFirstPop");
        assertEquals("afterFirstPop", stack.peek());

        assertEquals("afterFirstPop", stack.pop());
        assertEquals("secondObjectPushed", stack.peek());

        assertEquals(2, stack.size());

    }
    @Test
    public void secondTestForSize(){
        stack.push("objectToPush1");
        stack.push("objectToPush2");
        assertEquals("objectToPush2", stack.peek());
        assertEquals(2, stack.size());

        stack.push("objectToPush3");
        stack.push("objectToPush4");
        assertEquals("objectToPush4", stack.peek());
        assertEquals(4, stack.size());

        assertEquals("objectToPush4", stack.pop());
        assertEquals("objectToPush3", stack.peek());
        assertEquals(3, stack.size());
    }
    @Test
    public void testIsEmptyMethod(){

        assertTrue(stack.isEmpty());
        stack.push(null);
        assertFalse(stack.isEmpty());

        stack.pop();

        assertTrue(stack.isEmpty());
        stack.push("objectToPush2");

        stack.peek();
        assertFalse(stack.isEmpty());

    }
    @Test
    public void testSearchMethod(){

        stack.push("objectToPush1");
        stack.push("objectToPush2");

        assertEquals(1, stack.search("objectToPush2"));
        assertEquals(-1, stack.search("objectToPush"));
        assertEquals(2,stack.size());

        stack.push("new value");
        assertEquals(2, stack.search("new value"));
        assertEquals(3,stack.size());
    }
    @Test
    public void testStackUnderFlowException(){
        stack.push("new value");
        stack.pop();
        assertEquals(0,stack.size());
        assertThrows(MyStackUnderFlowException.class,() ->  stack.pop());
    }
    @Test
    public void testStackOverFlowException(){
        for (int i = 0; i < 100; i++) {
            stack.push("new value");
        }
        assertThrows(MyStackOverFlowException.class,() ->  stack.push("21"));
    }
    @Test
    public void testPushPopMethod(){
        MyStack <String> stack = new MyStack<>();
        stack.push("Week");
        stack.push("yes");
        stack.push("ancient");

        assertEquals("ancient", stack.pop());
    }
    @Test
    public void testPeekMethod(){
        MyStack <String> stack = new MyStack<>();
        stack.push("Week");
        stack.push("yes");
        stack.push("ancient");

        assertEquals("ancient", stack.peek());
        assertEquals("ancient", stack.peek());
        assertEquals("ancient", stack.pop());
        assertEquals("yes", stack.peek());

    }
    @Test
    public void testStackUnderFlow(){
        MyStack <String> stack = new MyStack<>();
        stack.push("Week");
        stack.push("yes");

        assertEquals("yes", stack.pop());
        assertEquals("Week", stack.pop());
        assertThrows(MyStackUnderFlowException.class, stack::pop);

    }
    @Test
    public void testStackOverFlow() {
        MyStack<String> stack = new MyStack<>();
        for (int count = 0; count < 100; count++) {
        stack.push("Week");
        }

        assertThrows(MyStackOverFlowException.class, () -> stack.push("anything"));

    }
}
