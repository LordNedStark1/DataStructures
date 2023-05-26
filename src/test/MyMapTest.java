package test;

import map.MyHashMap;
import map.MyMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyMapTest {
    MyMap<Integer, String> map;
    @BeforeEach
    public void setUp() {
        map = new MyHashMap<>();
    }
    @Test
    public void testSaveAndFindByKey(){

        MyMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value3");

        assertEquals("value1", map.getValue(1));
        assertEquals("value2", map.getValue(2));
        assertEquals("value3", map.getValue(3));

    }
    @Test
    public void testContainKeyMethod(){
        map.put(1, "value1");
        map.put(2, "value2");

        assertTrue(map.containsKey(1));
    }
}
