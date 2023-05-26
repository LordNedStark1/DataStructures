package test;

import arrayList.MyArrayList;
import arrayList.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class ListTest {
    MyList<String> list;
    @BeforeEach
    public void setup(){
         list = new MyArrayList<>();
    }
    @Test
    public void testListCapacity(){
        MyList <String>list = new MyArrayList<>();
        assertEquals(10, list.getCapacity());
    }
    @org.junit.Test
    @Test
    public void testAddMethod(){
        setup();
        list.add("my name");
        list.add("behaviour");
        assertEquals(2, list.size());

    }
    @Test
    public void testAddToCapacity(){
        setup();
        for (int i = 0; i < 10; i++){
            list.add("name"+ i);
        }
        assertEquals(list.size(), 10);
        assertEquals(list.getCapacity(),10);
    }
    @Test
    public void testCapacityOverFlow(){
        setup();
        for (int i = 1; i < 17; i++){
            list.add("name"+ i);
        }

        assertEquals(list.size(), 16);
        assertEquals(list.getCapacity(),20);
    }
    @Test
    public void testRemoveMethod(){
        setup();
        list.add("my name");
        list.add("index");
        list.add("other");
        list.add("behaviour");

        assertEquals("index", list.get(1));

        list.remove(1);
        assertEquals(list.size(), 3);

        assertEquals( list.get(2), "behaviour");

        boolean isPresent = false;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) == "index") {
                isPresent = true;
            }
        }
        assertFalse(isPresent);
    }

    @Test
    public void testInsertMethod(){
        setup();
        list.add("my name");
        list.add("index");
        list.add("other");
        list.add("behaviour");

        assertEquals("index", list.get(1));
        assertEquals(list.size(), 4);

        list.insert(1, "ned");

        assertEquals(list.get(1), "ned");
        assertEquals(list.get(2), "index");
        assertEquals(list.size(), 5);


    }
}
