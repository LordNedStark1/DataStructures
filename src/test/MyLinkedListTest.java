package test;

import list.MyLinkedList;
import list.MyList;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {
    MyLinkedList<String> myList = new MyLinkedList<>();
    @Test
    public void LinkedListNotNull(){

        assertNotNull(myList);
    }
    @Test
    public void LinkedListIsEmpty(){
        assertTrue(myList.isEmpty());
    }
    @Test
    public void LinkedListSizeIsZero(){
        assertEquals(0,myList.size());
    }
    @Test
    public void LinkedListCanBeAddedTo(){
        myList.add("first element");
        assertEquals(1,myList.size());
    }
}
