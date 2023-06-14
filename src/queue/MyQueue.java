package queue;

public interface MyQueue<T> {
    int size();

    void enqueue(T manager);

    T dequeue();

    boolean isEmpty();

    T peek();
}
