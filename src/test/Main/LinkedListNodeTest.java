package Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListNodeTest {

    LinkedListNode <Integer> testListInteger;
    LinkedListNode <Double> testListDouble;
    LinkedListNode <String> testListString;
    LinkedListNode <Boolean> testListBool;

    @BeforeEach
    void setUp() {
        testListBool = new LinkedListNode<>(false);
        testListBool.nextNode = new LinkedListNode<>(true);
        testListBool.nextNode.nextNode = new LinkedListNode<>(false);
        testListBool.nextNode.nextNode.nextNode = new LinkedListNode<>(true);
        testListBool.nextNode.nextNode.nextNode.nextNode = new LinkedListNode<>(false);
        testListBool.numberOfItemsInList = 5;

        testListInteger = new LinkedListNode<>(0);
        testListInteger.nextNode = new LinkedListNode<> (1);
        testListInteger.nextNode.nextNode = new LinkedListNode<>(2);
        testListInteger.nextNode.nextNode.nextNode = new LinkedListNode<>(3);
        testListInteger.nextNode.nextNode.nextNode.nextNode = new LinkedListNode<>(4);
        testListInteger.numberOfItemsInList = 5;

        testListDouble = new LinkedListNode<>(0.9);
        testListDouble.nextNode = new LinkedListNode<>(1.0);
        testListDouble.nextNode.nextNode = new LinkedListNode<>(2.1);
        testListDouble.nextNode.nextNode.nextNode = new LinkedListNode<>(3.2);
        testListDouble.nextNode.nextNode.nextNode.nextNode = new LinkedListNode<>(4.3);
        testListDouble.numberOfItemsInList = 5;

        testListString = new LinkedListNode<>("String 0");
        testListString.nextNode = new LinkedListNode<>("String 1");
        testListString.nextNode.nextNode = new LinkedListNode<>("String 2");
        testListString.nextNode.nextNode.nextNode = new LinkedListNode<>("String 3");
        testListString.nextNode.nextNode.nextNode.nextNode = new LinkedListNode<>("String 4");
        testListString.numberOfItemsInList = 5;
    }

    @Test
    void appendToList() {
        testListInteger.appendToList( 77);
        testListDouble.appendToList(77.7);
        testListString.appendToList( "String 77");
        testListBool.appendToList(true);

        assertEquals(77, testListInteger.getItem(5));
        assertEquals(77.7, testListDouble.getItem(5));
        assertEquals("String 77", testListString.getItem(5));
        assertEquals(true, testListBool.getItem(5));

        assertEquals(4, testListInteger.getItem(4));
        assertEquals(4.3, testListDouble.getItem(4));
        assertEquals("String 4", testListString.getItem(4));
        assertEquals(false, testListBool.getItem(4));
    }

    @Test
    void getItem() {
        assertEquals(0, testListInteger.getItem(0));
        assertEquals(4, testListInteger.getItem(4));

        assertEquals(false, testListBool.getItem(0));
        assertEquals(false, testListBool.getItem(4));

        assertEquals(0.9, testListDouble.getItem(0));
        assertEquals(4.3, testListDouble.getItem(4));

        assertEquals("String 0", testListString.getItem(0));
        assertEquals("String 4", testListString.getItem(4));
    }

    @Test
    void listToString() {
        assertEquals("0"+"\n"+ "1"+"\n"+ "2"+"\n"+ "3"+"\n"+ "4", testListInteger.toString());
        assertEquals("0.9"+"\n"+ "1.0"+"\n"+ "2.1"+"\n"+ "3.2"+"\n"+ "4.3", testListDouble.toString());
        assertEquals("String 0"+"\n"+ "String 1"+"\n"+ "String 2"+"\n"+ "String 3"+"\n"+ "String 4", testListString.toString());
        assertEquals("false"+"\n"+ "true"+"\n"+ "false"+"\n"+ "true"+"\n"+ "false", testListBool.toString());
    }

    @Test
    void insertItem() {
        //The following test insertion of an item at the beginning of the list.
        testListInteger.insertItem(0, 77);
        testListDouble.insertItem(0, 77.7);
        testListString.insertItem(0, "String 77");
        testListBool.insertItem(0, true);

        assertEquals(77, testListInteger.getItem(0));
        assertEquals(0, testListInteger.getItem(1));
        assertEquals(4, testListInteger.getItem(5));
        assertEquals(6, testListInteger.getLength());

        assertEquals(true, testListBool.getItem(0));
        assertEquals(false, testListBool.getItem(1));
        assertEquals(false, testListBool.getItem(5));
        assertEquals(6, testListInteger.getLength());

        assertEquals(77.7, testListDouble.getItem(0));
        assertEquals(0.9, testListDouble.getItem(1));
        assertEquals(4.3, testListDouble.getItem(5));
        assertEquals(6, testListInteger.getLength());

        assertEquals("String 77", testListString.getItem(0));
        assertEquals("String 0", testListString.getItem(1));
        assertEquals("String 4", testListString.getItem(5));
        assertEquals(6, testListString.getLength());


        // The following test insertion at the end of the list.
        setUp();
        testListInteger.insertItem(5, 77);
        testListDouble.insertItem(5, 77.7);
        testListString.insertItem(5, "String 77");
        testListBool.insertItem(5, true);

        assertEquals(4, testListInteger.getItem(4));
        assertEquals(0, testListInteger.getItem(0));
        assertEquals(77, testListInteger.getItem(5));
        assertEquals(6, testListInteger.getLength());

        assertEquals(true, testListBool.getItem(5));
        assertEquals(false, testListBool.getItem(0));
        assertEquals(false, testListBool.getItem(4));
        assertEquals(6, testListInteger.getLength());

        assertEquals(77.7, testListDouble.getItem(5));
        assertEquals(0.9, testListDouble.getItem(0));
        assertEquals(4.3, testListDouble.getItem(4));
        assertEquals(6, testListInteger.getLength());

        assertEquals("String 77", testListString.getItem(5));
        assertEquals("String 0", testListString.getItem(0));
        assertEquals("String 4", testListString.getItem(4));
        assertEquals(6, testListString.getLength());


        //The following test insertion of items in the middle of a list.
        setUp();
        testListInteger.insertItem(3, 77);
        testListDouble.insertItem(3, 77.7);
        testListString.insertItem(3, "String 77");
        testListBool.insertItem(3, true);

        assertEquals(77, testListInteger.getItem(3));
        assertEquals(0, testListInteger.getItem(0));
        assertEquals(4, testListInteger.getItem(5));
        assertEquals(6, testListInteger.getLength());

        assertEquals(true, testListBool.getItem(3));
        assertEquals(false, testListBool.getItem(0));
        assertEquals(false, testListBool.getItem(5));
        assertEquals(6, testListInteger.getLength());

        assertEquals(77.7, testListDouble.getItem(3));
        assertEquals(0.9, testListDouble.getItem(0));
        assertEquals(4.3, testListDouble.getItem(5));
        assertEquals(6, testListInteger.getLength());

        assertEquals("String 77", testListString.getItem(3));
        assertEquals("String 0", testListString.getItem(0));
        assertEquals("String 4", testListString.getItem(5));
        assertEquals(6, testListString.getLength());
    }

    @Test
    void deleteItem() {
        testListInteger.deleteItem(0);
        testListDouble.deleteItem(0);
        testListString.deleteItem(0);
        testListBool.deleteItem(0);

        assertEquals(1, testListInteger.data);
        assertEquals(4, testListInteger.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListInteger.getLength());

        assertEquals(true, testListBool.data);
        assertEquals(false, testListBool.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListInteger.getLength());

        assertEquals(1.0, testListDouble.data);
        assertEquals(4.3, testListDouble.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListInteger.getLength());

        assertEquals("String 1", testListString.data);
        assertEquals("String 4", testListString.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListString.getLength());

        setUp();
        testListInteger.deleteItem(4);
        testListDouble.deleteItem(4);
        testListString.deleteItem(4);
        testListBool.deleteItem(4);

        assertEquals(0, testListInteger.data);
        assertEquals(3, testListInteger.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListInteger.getLength());

        assertEquals(false, testListBool.data);
        assertEquals(true, testListBool.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListInteger.getLength());

        assertEquals(0.9, testListDouble.data);
        assertEquals(3.2, testListDouble.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListInteger.getLength());

        assertEquals("String 0", testListString.data);
        assertEquals("String 3", testListString.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListString.getLength());

        setUp();
        testListInteger.deleteItem(3);
        testListDouble.deleteItem(3);
        testListString.deleteItem(3);
        testListBool.deleteItem(3);

        assertEquals(0, testListInteger.data);
        assertEquals(2, testListInteger.nextNode.nextNode.data);
        assertEquals(4, testListInteger.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListInteger.getLength());

        assertEquals(false, testListBool.data);
        assertEquals(false, testListBool.nextNode.nextNode.data);
        assertEquals(false, testListBool.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListInteger.getLength());

        assertEquals(0.9, testListDouble.data);
        assertEquals(2.1, testListDouble.nextNode.nextNode.data);
        assertEquals(4.3, testListDouble.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListInteger.getLength());

        assertEquals("String 0", testListString.data);
        assertEquals("String 2", testListString.nextNode.nextNode.data);
        assertEquals("String 4", testListString.nextNode.nextNode.nextNode.data);
        assertEquals(4, testListString.getLength());

    }
}