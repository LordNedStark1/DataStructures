package queue;

import customExceptions.QueueEmptyException;
import customExceptions.QueueFullException;

import java.util.Arrays;

public class MyQueueOne<S> implements MyQueue<S> {
    private Object [] elements;
    private int currentPosition = 0 ;
    private int capacity = 10 ;
    private int lastIndexDeletedFrom = 0;
    private int currentSize;

    public MyQueueOne() {
        elements = new Object[capacity];
    }

    public void enqueue(S value) {
//        if (currentPosition == capacity){
//            adjustQueue();
//        }

        elements[currentPosition] = value;
        currentPosition++;
    }

    private void adjustQueue() {

        int adjustmentIndex = 0;
       for (int i = 0; i < elements.length; i++) {
        if (elements[i] == null){
           continue;
       }
        if (elements[i] != null) {
            elements[adjustmentIndex] = elements[i];
            adjustmentIndex++;
        }
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                currentPosition = i;
                break;
            } else if (elements[i] != null) {
                continue;
            }
            break;
        }
       lastIndexDeletedFrom = 0;
    }

    public int size() {
        return currentSize;
    }

    public S dequeue() {

        S value = (S) elements[lastIndexDeletedFrom];
        elements[lastIndexDeletedFrom] = null;
        lastIndexDeletedFrom++;
        if (isEmpty()){
            currentPosition = 0;
            lastIndexDeletedFrom = 0;
        }
        currentSize =  lastIndexDeletedFrom - currentPosition;
        return value;
    }

    public boolean isEmpty() {
        for (int i = 0; i < elements.length; i++) if (elements[i] != null) return false;
        return true;
    }

    @Override
    public S peek() {
        return (S) elements[lastIndexDeletedFrom];
    }

    public boolean isFull() {

        for (int i = 0; i < elements.length; i++) if (elements[i] == null) return false;
        return true;
    }
    public String toString() {
        return Arrays.toString(elements);
    }
}
