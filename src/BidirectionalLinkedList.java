public class BidirectionalLinkedList <Type> {

    private BidirectionalListNode<Type> listNode;

    public void appendToList (Type dataToAppend){
        if (listNode==null){
            listNode = new BidirectionalListNode<>(dataToAppend);
        }
        else{
            listNode.appendToList(dataToAppend);
        }
    }

    public Type getItem (int itemLocation){
        if (listNode==null){
            throw new IndexOutOfBoundsException("List was empty");
        }
        else if (itemLocation>listNode.getLength()){
            throw new IndexOutOfBoundsException("The requested location is greater than the list's length");
        }
        return listNode.getItem(itemLocation);
    }

    public void printList (){
        if (listNode==null){
            System.out.println("Sorry, your list is empty right now, and cannot be printed.");
        }
        else{
            listNode.printList();
        }
    }

    public int getLength (){
        if (listNode==null){
            throw new IndexOutOfBoundsException("List was empty");
        }
        return listNode.getLength();
    }

    public void insertItem(int insertLocation, Type dataToInsert){
        if (listNode==null){
            listNode = new BidirectionalListNode <>(dataToInsert);
        }
        else{
            listNode.insertItem(insertLocation, dataToInsert);
        }
    }
    public void deleteItem (int deleteLocation) {
        if (listNode == null) {
            throw new IndexOutOfBoundsException("List was empty");
        }
        else if (deleteLocation > listNode.getLength()) {
            throw new IndexOutOfBoundsException("The requested location is greater than the list's length");
        }
        else {
            listNode.deleteItem(deleteLocation);
        }
    }
}
