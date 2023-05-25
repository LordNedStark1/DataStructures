package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import algrithm.Multiplication;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationTest {
    Multiplication multiply;
    @BeforeEach
    public void setUp(){
        multiply = new Multiplication();
    }

    @Test
    public void testMultiply(){
        int one = 2;
        int two =  3;
        assertEquals(6, multiply.multiply(one, two));
    }   @Test
    public void testMultiplyTwoNegativeNumbers(){
        int one = -6;
        int two =  -6;
        assertEquals(36, multiply.multiply(one, two));
    }
    @Test
    public void testMultiplyByZero(){
        int one = 0;
        int two =  -6;
        assertEquals(0, multiply.multiply(one, two));
    } @Test
    public void testMultiplyByZeroAndPositiveNumber(){
        int one = 0;
        int two =  6;
        assertEquals(0, multiply.multiply(one, two));
    }
    @Test
    public void testMultiplyByOneNegativeAndOnePositive(){
        int one = 5;
        int two =  -6;
        assertEquals(-30, multiply.multiply(one, two));
    }@Test
    public void testTheFirstValueHasMinus(){
        int one = -10;
        int two =  10;
        assertEquals(-100, multiply.multiply(one, two));
    }
}

