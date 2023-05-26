package map;

public interface MyMap<T , S> {
    void put(T key, S value);

    S getValue(T key);
}
