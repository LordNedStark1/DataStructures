package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList <T> implements MyList{

    private int listCapacity = 10;
    private T type ;
    private Object [] elements ;
    private int sizeOrLastIndex;
    public MyArrayList() {
        elements = new Object [listCapacity];
    }
    @Override public int getCapacity() {
        return listCapacity;
    }
    private void setArray(){

    }
    @Override
    public void add(Object value) {

        if (elements[elements.length - 1] != null){

            increaseCapacity(elements.length);

        }
        elements[sizeOrLastIndex] = value;
        sizeOrLastIndex++;


    }

    private void increaseCapacity(int length) {
        Object [] newArray = new Object[length * 2 ];
        for (int index = 0; index < elements.length; index++) {
            newArray[index] = elements[index];
        }
        this.elements = newArray;

        listCapacity = elements.length;
    }

    @Override
    public long size() {
        return sizeOrLastIndex;
    }

    @Override
    public T get(int i) {

        return (T) elements[i];
    }

    @Override
    public void remove(int i) {
        elements[i] = null;
        for (int index = 0; index < elements.length; index++) {

            if (index+ 1 < elements.length) {
                if (elements[index] == null && elements[index + 1] != null) {
                    elements[index] = elements[index + 1];
                    elements[index + 1] = null;
                }
            }
        }
        sizeOrLastIndex--;
    }

    @Override
    public void insert(int indexToChange, Object newValue) {
        Object valueFromPreviousIndex = elements[indexToChange];
        elements[indexToChange] = newValue;

        if (indexToChange + 1 < elements.length) {

            Object valueFromNextIndex = elements[indexToChange + 1];
            elements[sizeOrLastIndex] = valueFromPreviousIndex;

            insert(indexToChange + 1, valueFromNextIndex);
        }

        sizeOrLastIndex ++;

    }

//    public String toString() {
//        return Arrays.toString(elements);
//    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < elements.length; i++) {
            if (i == elements.length - 1 && elements[i] != null) {
                result.append(elements[i]);
                break;
            }
            if (elements[i] != null ) {
                if (elements[i+1] != null) result.append( elements[i]+ ", ");
                else if (elements[i+1] == null) {
                    result.append( elements[i]);
                }
            }
        }
        return result.append("]").toString();
    }

//    @Override
//    public Iterator iterator() {
//        return ;
//    }
//
//    @Override
//    public void forEach(Consumer action) {
//        MyList.super.forEach(action);
//    }
//
//    @Override
//    public Spliterator spliterator() {
//        return MyList.super.spliterator();
//    }
}
