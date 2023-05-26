package test;

import customExceptions.MyStackUnderFlowError;
import org.junit.jupiter.api.Test;
import stack.MyStack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStackTest {
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
        assertEquals("week", stack.pop());
        assertThrows(new MyStackUnderFlowError("Stack UnderFlow Error"), stack.pop());

    }
}
