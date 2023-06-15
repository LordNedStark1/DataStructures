package list;

public class MyArrayList <T> implements MyList<T>{

    private int listCapacity = 10;
    private T type ;

    private Object [] elements ;
    private int sizeOrLastIndex;
    public MyArrayList(int neededSize) {
        elements = new Object [neededSize];
    }
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
//        System.arraycopy(elements, 0, newArray, 0, elements.length);
//        this.elements = newArray;
        this.elements = newArray;

        listCapacity = elements.length;
    }

    @Override
    public int size() {
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
    public boolean remove(T objectToRemove) {
        for (int index = 0; index < elements.length; index++) {
            if (elements[index] == objectToRemove) {
                elements[index] = null;
                if (index + 1 < elements.length) {
                    if (elements[index] == null && elements[index + 1] != null) {
                        elements[index] = elements[index + 1];
                        elements[index + 1] = null;
                    }
                }
                sizeOrLastIndex--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void insert(int indexToChange, Object newValue) {
        if (elements[elements.length - 1] != null){

            increaseCapacity(elements.length);

        }
        Object valueFromPreviousIndex = elements[indexToChange];
        elements[indexToChange] = newValue;
        int nextIndex = indexToChange + 1;

        if (nextIndex < sizeOrLastIndex) {
            Object valueFromNextIndex = elements[nextIndex];
            elements[nextIndex] = valueFromPreviousIndex;
            insert(nextIndex + 1, valueFromNextIndex);
        }if(nextIndex == sizeOrLastIndex) {
            elements[nextIndex] = valueFromPreviousIndex;
        }
        else {

            sizeOrLastIndex++;
            return;
        }
    }

    @Override
    public boolean contains(Object valueToCheck) {
        for (int index = 0; index < sizeOrLastIndex; index++) {
            if (elements[index].equals(valueToCheck))
                return true;
        }
        return false;
    }


    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < elements.length; i++) {
            if (i == elements.length - 1 && elements[i] != null) {
                result.append(elements[i]);
                break;
            }
            if (elements[i] != null ) {
                if (elements[i+1] != null) result.append(elements[i]).append(", ");
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
