package arrayList;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList <T> implements MyList{

    private int listCapacity = 10;
    private T type ;
    private String [] elements ;
    private int index;
    public MyArrayList() {
        elements = new String [listCapacity];

    }
    //    public MyArrayList(int capacity, T type) {
//        this.type = type;
//       elements =  new String [listCapacity];
//    }

    @Override public int getCapacity() {
        return listCapacity;
    }
    private void setArray(){

    }
    @Override
    public void add(String value) {

        if (elements[elements.length - 1] != null){

            increaseCapacity(elements.length);

        }
        elements[index] = value;
        index++;


    }

    private void increaseCapacity(int length) {
        String [] newArray = new String[length * 2 ];
        for (int index = 0; index < elements.length; index++) {
            newArray[index] = elements[index];
        }
        this.elements = newArray;

        listCapacity = elements.length;
    }

    @Override
    public long size() {
        return index;
    }

    @Override
    public String get(int i) {
        return elements[i];
    }

    @Override
    public void remove(int i) {
        String [] arr = new String[listCapacity];
        for(int index = 0; index < elements.length; index++) {

            if (index == i) {
                int newIndex = index;
                newIndex++;
                arr[index] = elements[newIndex];
                index += 1;

            }else {

                arr[index] = elements[index];
            }
        }
        elements = arr;

        index--;
    }
    public String toString() {
        return Arrays.toString(elements);
    }

}
