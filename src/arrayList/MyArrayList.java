package arrayList;

import java.util.ArrayList;

public class MyArrayList <T> {
    private int arrayCapacity = 10;
    private T [] number ;
    private int index = 0;

    public void add(T value) {
        number[index] = value;
        index++;
    }
    public int size() {
        return index;
    }
    public void remove(int index) {
        number[index] = 0;
        this.index--;
    }
}
