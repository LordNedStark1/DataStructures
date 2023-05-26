package test;

import map.MyHashMap;
import map.MyMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMapTest {
    @Test
    public void testSaveAndFindByKey(){
//        Map map = new HashMap();
//        map.
        MyMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value3");

        assertEquals("value1", map.getValue(1));
        assertEquals("value2", map.getValue(2));
        assertEquals("value3", map.getValue(3));

    }
}
