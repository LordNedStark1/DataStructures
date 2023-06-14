package test;

import LinkedList.MyNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    MyNode <String> node = new MyNode<>();

    @Test
    public void testNodeExist(){
        MyNode<String> node = new MyNode<>();
        assertNotNull(node);
    }
    @Test
    public void testThatNodeHasAValue(){
        node.setValue("value");
        assertEquals("value", node.getValue());
    }
    @Test
    public void testThatNodeHasNext(){
        node.setValue("value");
        node.setNext(new MyNode<String>());
        assertNotNull(node.getNext());
    }
    @Test
    public void testThatNodeCanGetNextValue(){
        MyNode<String> nextNode = new MyNode<String>();
        nextNode.setValue("value");
        node.setNext(nextNode);
        assertSame(nextNode, node.getNext());
        assertEquals("value", node.getNext().getValue());
    }
    @Test
    public void testThatNodeHasPrevious(){

    }

}
