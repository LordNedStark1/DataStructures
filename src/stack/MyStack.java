package stack;

import customExceptions.MyStackOverFlowException;
import customExceptions.MyStackUnderFlowException;

public class MyStack<S> {
    private int  size;
    private final int stackMaximumCapacity = 100;
    Object [] myStack = new Object[stackMaximumCapacity];
    public void push(S value) {
        if (size + 1 > stackMaximumCapacity) {
            throw new MyStackOverFlowException("Stack OverFlow Exception");
        }
        myStack[size] = value;
        size++;
    }
    public S pop() {
        if (size - 1 < 0) {
            throw new MyStackUnderFlowException("Stack UnderFlow Exception");
        }
        size--;
        S value = (S) myStack[size];
        myStack[myStack.length - 1] = null;
        return value;
    }

    public S peek() {
        return (S) myStack[size - 1];
    }
}
