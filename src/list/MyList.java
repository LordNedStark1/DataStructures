package list;

public interface MyList <T>  {
    int getCapacity();

    void add(T my_name);

    int size();

    T get(int i);

    void remove(int i);

    void insert(int i, T ned);

    boolean contains(T valueToCheck);

    boolean remove(T objectToRemove);

    boolean isEmpty();
}
