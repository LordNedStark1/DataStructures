package queue;

import list.MyArrayList;
import list.MyList;

public class MyQueueTwo <T> implements MyQueue<T>{
    MyList<T> myList ;
    public MyQueueTwo(int neededSize) {
        myList = new MyArrayList<>(neededSize);
    }
    public int size() {
        return myList.size();
    }

    public void enqueue(T valueToEnqueue) {
        myList.add(valueToEnqueue);
    }

    public T dequeue() {
        T valueToDequeue = myList.get(0);
        myList.remove(0);

        return valueToDequeue;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T peek() {
        return null;
    }

    public String toString() {
        return myList.toString();
    }
}
