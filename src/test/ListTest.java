package test;

import list.MyArrayList;
import list.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    @org.junit.Test
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
            if (list.get(index).equals( "index")) {
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

        assertEquals(list.get(0), "my name");
        assertEquals(list.get(1), "ned");
        assertEquals(list.get(2), "index");
        assertEquals(list.get(3), "other");
        assertEquals(list.get(4), "behaviour");
        assertEquals(list.size(), 5);
    }

    @Test
    public void testContainsMethod(){
        setup();
        list.add("my name");
        list.add("index");
        list.add("other");
        list.add("behaviour");
        list.insert(1, "ned");

        assertTrue(list.contains("my name"));
        assertTrue(list.contains("ned"));
        assertTrue(list.contains("behaviour"));
        assertFalse(list.contains("name"));
    }
//    @Test
//    public void onInsertTestThatCapacityIncreasesIfFull(){
//            setup();
//        for (int i = 0; i < 9; i++) {
//            list.add("added");
//        }
//        assertEquals(9,list.size());
//        list.insert(3,"inserted");
//
//        list.insert(3,"inserted");
//        list.insert(3,"inserted");
//        assertEquals(list.size(),12);
//    }
    @Test
    public void testRemoveMethodReturnsABooleanIfTheObjectIsRemovedOrNot(){
        setup();
        list.add("my name");
        list.add("index");
        list.add("other");
        list.add("behaviour");
        list.insert(1, "ned");

        assertTrue( list.remove("other"));
        assertFalse( list.contains("other"));
        assertEquals(list.size(), 4);

    }
}
