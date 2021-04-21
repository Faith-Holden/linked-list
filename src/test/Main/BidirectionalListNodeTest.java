package Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BidirectionalListNodeTest {

    BidirectionalListNode <Integer> testListInteger;
    BidirectionalListNode <Double> testListDouble;
    BidirectionalListNode <String> testListString;
    BidirectionalListNode <Boolean> testListBool;

    @BeforeEach
    void setUp() {
        testListBool = new BidirectionalListNode<>(false);
        testListBool.nextNode = new BidirectionalListNode<>(true);
        testListBool.nextNode.previousNode = testListBool;
        testListBool.nextNode.nextNode = new BidirectionalListNode <>(false);
        testListBool.nextNode.nextNode.previousNode = testListBool.nextNode;
        testListBool.nextNode.nextNode.nextNode = new BidirectionalListNode<>(true);
        testListBool.nextNode.nextNode.nextNode.previousNode = testListBool.nextNode.nextNode;
        testListBool.nextNode.nextNode.nextNode.nextNode = new BidirectionalListNode<>(false);
        testListBool.nextNode.nextNode.nextNode.nextNode.previousNode = testListBool.nextNode.nextNode.nextNode;
        testListBool.numberOfItemsInList = 5;

        testListInteger = new BidirectionalListNode<>(0);
        testListInteger.nextNode = new BidirectionalListNode<> (1);
        testListInteger.nextNode.previousNode = testListInteger;
        testListInteger.nextNode.nextNode = new BidirectionalListNode <>(2);
        testListInteger.nextNode.nextNode.previousNode = testListInteger.nextNode;
        testListInteger.nextNode.nextNode.nextNode = new BidirectionalListNode <>(3);
        testListInteger.nextNode.nextNode.nextNode.previousNode = testListInteger.nextNode.nextNode;
        testListInteger.nextNode.nextNode.nextNode.nextNode = new BidirectionalListNode <>(4);
        testListInteger.nextNode.nextNode.nextNode.nextNode.previousNode = testListInteger.nextNode.nextNode.nextNode;
        testListInteger.numberOfItemsInList = 5;

        testListDouble = new BidirectionalListNode<>(0.9);
        testListDouble.nextNode = new BidirectionalListNode <>(1.0);
        testListDouble.nextNode.previousNode = testListDouble;
        testListDouble.nextNode.nextNode = new BidirectionalListNode <>(2.1);
        testListDouble.nextNode.nextNode.previousNode = testListDouble.nextNode;
        testListDouble.nextNode.nextNode.nextNode = new BidirectionalListNode <>(3.2);
        testListDouble.nextNode.nextNode.nextNode.previousNode = testListDouble.nextNode.nextNode;
        testListDouble.nextNode.nextNode.nextNode.nextNode = new BidirectionalListNode <>(4.3);
        testListDouble.nextNode.nextNode.nextNode.nextNode.previousNode = testListDouble.nextNode.nextNode.nextNode;
        testListDouble.numberOfItemsInList = 5;

        testListString = new BidirectionalListNode<>("String 0");
        testListString.nextNode = new BidirectionalListNode<>("String 1");
        testListString.nextNode.previousNode = testListString;
        testListString.nextNode.nextNode = new BidirectionalListNode<>("String 2");
        testListString.nextNode.nextNode.previousNode = testListString.nextNode;
        testListString.nextNode.nextNode.nextNode = new BidirectionalListNode<>("String 3");
        testListString.nextNode.nextNode.nextNode.previousNode = testListString.nextNode.nextNode;
        testListString.nextNode.nextNode.nextNode.nextNode = new BidirectionalListNode <>("String 4");
        testListString.nextNode.nextNode.nextNode.nextNode.previousNode = testListString.nextNode.nextNode.nextNode;
        testListString.numberOfItemsInList = 5;
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
    void appendToList() {
        //test append to non-empty list (BidirectionalListNode cannot be instantiated without data).
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
    void deleteItem() {
        testListInteger.deleteItem(0);
        testListDouble.deleteItem(0);
        testListString.deleteItem(0);
        testListBool.deleteItem(0);

        assertEquals(1, testListInteger.nodeData);
        assertEquals(4, testListInteger.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.getLength());

        assertEquals(true, testListBool.nodeData);
        assertEquals(false, testListBool.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.getLength());

        assertEquals(1.0, testListDouble.nodeData);
        assertEquals(4.3, testListDouble.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.getLength());

        assertEquals("String 1", testListString.nodeData);
        assertEquals("String 4", testListString.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListString.getLength());

        setUp();
        testListInteger.deleteItem(4);
        testListDouble.deleteItem(4);
        testListString.deleteItem(4);
        testListBool.deleteItem(4);

        assertEquals(0, testListInteger.nodeData);
        assertEquals(3, testListInteger.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.getLength());

        assertEquals(false, testListBool.nodeData);
        assertEquals(true, testListBool.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.getLength());

        assertEquals(0.9, testListDouble.nodeData);
        assertEquals(3.2, testListDouble.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.getLength());

        assertEquals("String 0", testListString.nodeData);
        assertEquals("String 3", testListString.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListString.getLength());

        setUp();
        testListInteger.deleteItem(3);
        testListDouble.deleteItem(3);
        testListString.deleteItem(3);
        testListBool.deleteItem(3);

        assertEquals(0, testListInteger.nodeData);
        assertEquals(2, testListInteger.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.getLength());

        assertEquals(false, testListBool.nodeData);
        assertEquals(false, testListBool.nextNode.nextNode.nodeData);
        assertEquals(false, testListBool.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.getLength());

        assertEquals(0.9, testListDouble.nodeData);
        assertEquals(2.1, testListDouble.nextNode.nextNode.nodeData);
        assertEquals(4.3, testListDouble.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListInteger.getLength());

        assertEquals("String 0", testListString.nodeData);
        assertEquals("String 2", testListString.nextNode.nextNode.nodeData);
        assertEquals("String 4", testListString.nextNode.nextNode.nextNode.nodeData);
        assertEquals(4, testListString.getLength());

    }

    @Test
    void listToString() {
        assertEquals("0"+"\n"+ "1"+"\n"+ "2"+"\n"+ "3"+"\n"+ "4", testListInteger.toString());
        assertEquals("0.9"+"\n"+ "1.0"+"\n"+ "2.1"+"\n"+ "3.2"+"\n"+ "4.3", testListDouble.toString());
        assertEquals("String 0"+"\n"+ "String 1"+"\n"+ "String 2"+"\n"+ "String 3"+"\n"+ "String 4", testListString.toString());
        assertEquals("false"+"\n"+ "true"+"\n"+ "false"+"\n"+ "true"+"\n"+ "false", testListBool.toString());
    }
}