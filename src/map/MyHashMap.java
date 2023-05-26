package map;

import list.MyArrayList;
import list.MyList;
import set.MySet;

public class MyHashMap<T , S> implements MyMap<T, S> {
    MySet<T> mySet = new MySet<T>();
    MyList<S> myList = new MyArrayList<>();

    @Override
    public void put(T key, S value) {
        mySet.add(key);
        myList.add(value);

    }

    @Override
    public S getValue(T key) {
//        return myList(mySet.getIndex(key));

        return null;
    }
}
