package stack;

import customExceptions.MyStackOverFlowException;
import customExceptions.MyStackUnderFlowException;
import list.MyArrayList;
import list.MyList;

public class MyStack<T> {

    private MyList<T> myList = new MyArrayList<T>();
    private int sizeOrLastIndex = 0;
    private int stackSize = 100;
    public void push(T objectToAdd) {
        if (sizeOrLastIndex == stackSize ){
            throw new StackOverFlowException("Stack overflow Exception");
        }
        myList.add(objectToAdd);
        sizeOrLastIndex++;
    }

    public T peek() {
        return myList.get(sizeOrLastIndex - 1);
    }

    public T pop() {
        if (sizeOrLastIndex == 0) {
            throw new StackUnderFlowException("Stack underflow Exception");
        }
        T objectToPop = peek();
        myList.remove(sizeOrLastIndex--);

        return objectToPop;
    }

    public int size() {
        return sizeOrLastIndex;
    }

    public boolean isEmpty() {
        return sizeOrLastIndex - 1 == -1;
    }

    public int search(T objectToSearch) {
        for(int index = 0; index < myList.size(); index++)
            if (myList.get(index) == objectToSearch)
                return index;

        return -1;
    }






//    private int  size;
//    private final int stackMaximumCapacity = 100;
//    Object [] myStack = new Object[stackMaximumCapacity];
//    public void push(T value) {
//        if (size + 1 > stackMaximumCapacity) {
//            throw new MyStackOverFlowException("Stack OverFlow Exception");
//        }
//        myStack[size] = value;
//        size++;
//    }
//    public T pop() {
//        if (size - 1 < 0) {
//            throw new MyStackUnderFlowException("Stack UnderFlow Exception");
//        }
//        size--;
//        T value = (T) myStack[size];
//        myStack[myStack.length - 1] = null;
//        return value;
//    }
//
//    public T peek() {
//        return (T) myStack[size - 1];
//    }
}
