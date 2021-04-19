public class TestLinkedList {
    public static void main (String [] args){
        BidirectionalLinkedList<Integer> test = new BidirectionalLinkedList<>();
//        BidirectionalLinkedList test= new BidirectionalLinkedList();
//        LinkedList test = new LinkedList();
        test.appendToList(1);
        test.appendToList(2);
        test.appendToList(3);
        test.appendToList(4);
        test.appendToList(5);
        System.out.println("The list is ");
        test.printList();
        System.out.println("The linked list's length is " + test.getLength());
        System.out.println("The item at location " + 2 + " is " + test.getItem(2));
        test.insertItem(0, 77);
        System.out.println("After inserting your item, the new list is ");
        test.printList();
        System.out.println("The linked list's length is " + test.getLength());
        test.deleteItem(0);
        System.out.println("After deleting the item at the specified location, the new list is ");
        test.printList();
        System.out.println("The linked list's length is " + test.getLength());

    }
}
