package queue;

import customExceptions.QueueEmptyException;
import customExceptions.QueueFullException;

public class MyQueue<S> {
    private Object [] elements;
    private int lastIndexAddedTo;
    private int lastIndexDeletedFrom;
    public MyQueue(int size) {
        elements = new Object[size];
    }

    public void enqueue(S value) {
        if (lastIndexAddedTo == elements.length -1){
            adjustQueue();
        }
        elements[lastIndexAddedTo] = value;
        lastIndexAddedTo++;
    }

    private void adjustQueue() {
        if (isFull()) {
            throw new QueueFullException("Cannot add property to full queue ");
        }
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
                lastIndexAddedTo = i;
                break;
            } else if (elements[i] != null) {
                continue;
            }
            break;
        }
       lastIndexDeletedFrom = 0;
    }

    public int size() {
        return elements.length;
    }

    public S dequeue() {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot remove property from empty queue");
        }
        S value = (S) elements[lastIndexDeletedFrom];
        elements[lastIndexDeletedFrom] = null;
        lastIndexDeletedFrom++;
        if (isEmpty()){
            lastIndexAddedTo = 0;
            lastIndexDeletedFrom = 0;
        }
        return value;
    }

    public boolean isEmpty() {
        for (int i = 0; i < elements.length; i++) if (elements[i] != null) return false;
        return true;
    }
    public boolean isFull() {

        for (int i = 0; i < elements.length; i++) if (elements[i] == null) return false;
        return true;
    }
}
