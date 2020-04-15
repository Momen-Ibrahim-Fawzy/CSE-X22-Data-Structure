package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SingleLinkedListTest0 {
    @org.junit.jupiter.api.Test
    void addTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.head.getElement());
    }
    @org.junit.jupiter.api.Test
    void addTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
    }
    @org.junit.jupiter.api.Test
    void addTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
        assertEquals(55,e.head.getNext().getNext().getElement());
    }
    @org.junit.jupiter.api.Test
    void addTestFour() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);
        e.add(3,60);
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
        assertEquals(55,e.head.getNext().getNext().getElement());
        assertThrows(NullPointerException.class,()->e.add(5,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void addTestFive() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        e.add(2,60);//45,50,60,55
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
        assertEquals(60,e.head.getNext().getNext().getElement());
        assertEquals(55,e.head.getNext().getNext().getNext().getElement());
        e.add(4,70);//45,50,60,55,70
        assertEquals(45,e.head.getElement());
        assertEquals(50,e.head.getNext().getElement());
        assertEquals(60,e.head.getNext().getNext().getElement());
        assertEquals(55,e.head.getNext().getNext().getNext().getElement());
        assertEquals(70,e.head.getNext().getNext().getNext().getNext().getElement());
        assertThrows(NullPointerException.class,()->e.add(6,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(7,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void addTestSix() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.add(1,60));//the list is short
        e.add(0,45);
        assertEquals(45,e.head.getElement());
        assertThrows(NullPointerException.class,()->e.add(3,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void addTestSeven() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.add(1,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.add(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void getTestOne() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        assertEquals(45,e.get(0));
        assertEquals(50,e.get(1));
        assertEquals(55,e.get(2));
        assertThrows(NullPointerException.class,()->e.get(3));//the list is short
        assertThrows(NullPointerException.class,()->e.get(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void getTestTwo() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.get(3));//the list is short
        assertThrows(NullPointerException.class,()->e.get(2));//the list is short
        assertThrows(NullPointerException.class,()->e.get(1));//the list is short
        assertThrows(NullPointerException.class,()->e.get(0));//the list is short
        assertThrows(NullPointerException.class,()->e.get(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void getTestTrere() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);//45
        assertEquals(45,e.get(0));
        assertThrows(NullPointerException.class,()->e.get(3));//the list is short
        assertThrows(NullPointerException.class,()->e.get(2));//the list is short
        assertThrows(NullPointerException.class,()->e.get(1));//the list is short
        assertThrows(NullPointerException.class,()->e.get(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void setTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.set(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(1,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(0,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void setTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);//45
        e.set(0,60);//60
        assertEquals(60,e.get(0));
        assertThrows(NullPointerException.class,()->e.set(2,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(1,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void setTestTrere() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        e.set(2,60);//45,50,60
        assertEquals(60,e.get(2));
        assertThrows(NullPointerException.class,()->e.set(3,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(4,60));//the list is short
        assertThrows(NullPointerException.class,()->e.set(-1,60));//nothing
    }
    @org.junit.jupiter.api.Test
    void clearTestZero() {
        //null linked list
        SingleLinkedList e = null;
        assertThrows(NullPointerException.class,()->e.clear());
    }
    @org.junit.jupiter.api.Test
    void clearTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        e.clear();
        assertEquals(null,e.head);
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void clearTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.clear();
        assertEquals(null,e.head);
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void clearTestTrere() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        e.clear();
        assertEquals(null,e.head);
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertEquals(true,e.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        assertEquals(false,e.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyTestTrere() {
        //linked list with there element
        //add in index:
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        e.add(55);//45,50,55
        assertEquals(false,e.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void removeTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertThrows(NullPointerException.class,()->e.remove(0));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(1));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void removeTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.remove(0);
        assertEquals(true,e.isEmpty());
        e.add(45);
        e.remove(0);
        assertThrows(NullPointerException.class,()->e.remove(1));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(2));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(0));//the list is short
        e.add(45);
        assertThrows(NullPointerException.class,()->e.remove(1));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(2));//the list is short
        e.remove(0);
        assertEquals(true,e.isEmpty());
        assertThrows(NullPointerException.class,()->e.remove(0));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void removeTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);//45,50
        e.remove(0);//50
        assertEquals(50,e.head.getElement());
        e.add(45);//50,45
        e.remove(1);//50
        assertEquals(50,e.head.getElement());
        assertThrows(NullPointerException.class,()->e.remove(2));//the list is short
        assertThrows(NullPointerException.class,()->e.remove(1));//the list is short
        e.remove(0);
        assertEquals(true,e.isEmpty());
        assertThrows(NullPointerException.class,()->e.remove(-1));//nothing
    }
    @org.junit.jupiter.api.Test
    void sizeTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertEquals(0,e.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        assertEquals(1,e.size());
    }
    @org.junit.jupiter.api.Test
    void sizeTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        assertEquals(2,e.size());
    }
    @org.junit.jupiter.api.Test
    void containsTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();
        assertEquals(false,e.contains(1));
        assertEquals(false,e.contains(2));
        assertEquals(false,e.contains(100));
    }
    @org.junit.jupiter.api.Test
    void containsTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        assertEquals(true,e.contains(45));
        assertEquals(false,e.contains(1));
        assertEquals(false,e.contains(2));
        assertEquals(false,e.contains(100));
    }
    @org.junit.jupiter.api.Test
    void containsTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
        assertEquals(true,e.contains(45));
        assertEquals(true,e.contains(50));
        assertEquals(false,e.contains(1));
        assertEquals(false,e.contains(2));
        assertEquals(false,e.contains(100));
    }
    @org.junit.jupiter.api.Test
    void sublistTestOne() {
        //empty linked list
        SingleLinkedList e = new SingleLinkedList();

    }
    @org.junit.jupiter.api.Test
    void sublistTestTwo() {
        //linked list with one element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);

    }
    @org.junit.jupiter.api.Test
    void sublistTestThere() {
        //linked list with two element
        SingleLinkedList e = new SingleLinkedList();
        e.add(45);
        e.add(50);
    }
}