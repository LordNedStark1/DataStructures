package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import set.MySet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySetTest {
    MySet <Integer> set;
    @BeforeEach
    public void setUp(){
        set = new MySet<>();
    }
    @Test
    public void testSetAddMethod(){

        set.add(4);
        set.add(5);
        set.add(6);

        assertEquals(3, set.size());

    }
    @Test
    public void testForDuplication(){

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
    @Test
    public void testIsPresent(){
        Set
        set.add(4);
        set.add(9);
        set.add(6);
        set.add(7);
        assertTrue(set.isPresent(4));
    }
    @Test
    public void testFindIndex(){
        set.add(4);
        set.add(9);
        set.add(6);

        assertEquals(1, set.getIndex());
    }
}
