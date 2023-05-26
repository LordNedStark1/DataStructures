package arrayList;

public interface MyList <T>  {
    int getCapacity();

    void add(T my_name);

    long size();

    T get(int i);

    void remove(int i);

    void insert(int i, T ned);
}
