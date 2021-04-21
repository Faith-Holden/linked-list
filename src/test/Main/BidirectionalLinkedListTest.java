package Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BidirectionalLinkedListTest {

    BidirectionalLinkedList <Integer> testListInteger;
    BidirectionalLinkedList <Double> testListDouble;
    BidirectionalLinkedList <String> testListString;
    BidirectionalLinkedList <Boolean> testListBool;

    @BeforeEach
    void setUp() {
        testListInteger = new BidirectionalLinkedList<>();
        testListString = new BidirectionalLinkedList<>();
        testListBool =new BidirectionalLinkedList<>();
        testListDouble = new BidirectionalLinkedList<>();

        testListString.appendToList("String 0");
        testListString.appendToList("String 1");
        testListString.appendToList("String 2");
        testListString.appendToList("String 3");
        testListString.appendToList("String 4");

        testListBool.appendToList(false);
        testListBool.appendToList(true);
        testListBool.appendToList(false);
        testListBool.appendToList(true);
        testListBool.appendToList(false);

        testListDouble.appendToList(0.9);
        testListDouble.appendToList(1.0);
        testListDouble.appendToList(2.1);
        testListDouble.appendToList(3.2);
        testListDouble.appendToList(4.3);

        testListInteger.appendToList(0);
        testListInteger.appendToList(1);
        testListInteger.appendToList(2);
        testListInteger.appendToList(3);
        testListInteger.appendToList(4);
    }

    @Test
    void appendToList() {
        //test append to non-empty list
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

        //test append to empty list
        BidirectionalLinkedList <Integer> testEmptyListInt = new BidirectionalLinkedList<>();
        BidirectionalLinkedList <Boolean> testEmptyListBool = new BidirectionalLinkedList<>();
        BidirectionalLinkedList <String> testEmptyListString = new BidirectionalLinkedList<>();
        BidirectionalLinkedList <Double> testEmptyListDouble = new BidirectionalLinkedList<>();

        testEmptyListInt.appendToList( 77);
        testEmptyListDouble.appendToList( 77.7);
        testEmptyListString.appendToList( "String 77");
        testEmptyListBool.appendToList(true);

        assertEquals(77, testEmptyListInt.getItem(0));
        assertEquals(77.7, testEmptyListDouble.getItem(0));
        assertEquals("String 77", testEmptyListString.getItem(0));
        assertEquals(true, testEmptyListBool.getItem(0));
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
    void getLength() {
        assertEquals(5, testListInteger.getLength());
        assertEquals(5, testListDouble.getLength());
        assertEquals(5, testListString.getLength());
        assertEquals(5, testListBool.getLength());
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

        assertEquals(1, testListInteger.getItem(0));
        assertEquals(4, testListInteger.getItem(3));
        assertEquals(4, testListInteger.getLength());

        assertEquals(true, testListBool.getItem(0));
        assertEquals(false, testListBool.getItem(3));
        assertEquals(4, testListInteger.getLength());

        assertEquals(1.0, testListDouble.getItem(0));
        assertEquals(4.3, testListDouble.getItem(3));
        assertEquals(4, testListInteger.getLength());

        assertEquals("String 1", testListString.getItem(0));
        assertEquals("String 4", testListString.getItem(3));
        assertEquals(4, testListString.getLength());

        setUp();
        testListInteger.deleteItem(4);
        testListDouble.deleteItem(4);
        testListString.deleteItem(4);
        testListBool.deleteItem(4);

        assertEquals(0, testListInteger.getItem(0));
        assertEquals(3, testListInteger.getItem(3));
        assertEquals(4, testListInteger.getLength());

        assertEquals(false, testListBool.getItem(0));
        assertEquals(true, testListBool.getItem(3));
        assertEquals(4, testListInteger.getLength());

        assertEquals(0.9, testListDouble.getItem(0));
        assertEquals(3.2, testListDouble.getItem(3));
        assertEquals(4, testListInteger.getLength());

        assertEquals("String 0", testListString.getItem(0));
        assertEquals("String 3", testListString.getItem(3));
        assertEquals(4, testListString.getLength());

        setUp();
        testListInteger.deleteItem(3);
        testListDouble.deleteItem(3);
        testListString.deleteItem(3);
        testListBool.deleteItem(3);

        assertEquals(0, testListInteger.getItem(0));
        assertEquals(2, testListInteger.getItem(2));
        assertEquals(4, testListInteger.getItem(3));
        assertEquals(4, testListInteger.getLength());

        assertEquals(false, testListBool.getItem(0));
        assertEquals(false, testListBool.getItem(2));
        assertEquals(false, testListBool.getItem(3));
        assertEquals(4, testListInteger.getLength());

        assertEquals(0.9, testListDouble.getItem(0));
        assertEquals(2.1, testListDouble.getItem(2));
        assertEquals(4.3, testListDouble.getItem(3));
        assertEquals(4, testListInteger.getLength());

        assertEquals("String 0", testListString.getItem(0));
        assertEquals("String 2", testListString.getItem(2));
        assertEquals("String 4", testListString.getItem(3));
        assertEquals(4, testListString.getLength());
    }
}