package map;

import list.MyArrayList;
import list.MyList;
import set.MySet;

public class MyHashMap<T , S> implements MyMap<T, S> {
    MySet<T> keys = new MySet<T>();
    MyList<S> values = new MyArrayList<>();

    @Override
    public void put(T key, S value) {
        keys.add(key);
        values.add(value);

    }

    @Override
    public S getValue(T key) {
        return values.get(keys.getIndex(key));
    }

    @Override
    public boolean containsKey(T key) {
        T [] keysArray = toArray();
        for (int index = 0; index < keysArray.length; index++) {
            if (keysArray[index] == key) return true;
        }
        return false;
    }

    public T[] toArray() {
        Object [] array = new Object [keys.size()];
        for (int i = 0; i < array.length ; i++) {
            array[i] = keys;
        }
        return (T[]) array;
    }
}
