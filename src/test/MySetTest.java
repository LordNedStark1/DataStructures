package test;

import org.junit.jupiter.api.Test;
import set.MySet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MySetTest {
    @Test
    public void testSetAddMethod(){
        MySet <Integer> set = new MySet<>();
        set.add(4);
        set.add(5);
        set.add(6);

        assertEquals(3, set.size());

    }
    @Test
    public void testForDuplication(){
        MySet <Integer> set = new MySet<>();
        set.add(4);
        set.add(9);
        set.add(6);
        set.add(7);
        set.add(9);
        set.add(4);
        set.add(2);
        set.add(2);
        System.out.println(set);
        String expected = "{ 4, 9, 6, 7, 2 }";
        assertEquals(5, set.size());
    }
}
