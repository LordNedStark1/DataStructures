package stack;

import arrayList.MyArrayList;
import arrayList.MyList;
import customExceptions.MyStackUnderFlowError;

public class MyStack<S> {
    private int  size;
    Object [] myStack = new Object[70];
    public void push(S value) {
        myStack[size] = value;
    }
    public S pop() {
        if (myStack[0] == null) {
            throw new MyStackUnderFlowError("Stack UnderFlow Error");
        }
        S value = (S) myStack[myStack.length - 1];
        myStack.remove(myStack.size() - 1);
        return value;
    }

    public S peek() {
        return myStack.get(myStack.size() - 1);
    }
}
