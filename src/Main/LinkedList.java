package Main;

public class LinkedList <Type> {
    private LinkedListNode<Type> listNode;

    public void appendToList (Type dataToAppend){
        if (listNode==null){
            listNode = new LinkedListNode<>(dataToAppend);
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

    public String toString (){
        if (listNode==null){
            throw new IndexOutOfBoundsException ("Sorry, your list is empty right now, and cannot be printed.");
        }
        return listNode.toString();
    }

    public int getLength (){
        if (listNode==null){
            throw new IndexOutOfBoundsException("List was empty");
        }
        return listNode.getLength();
    }

    public void insertItem(int insertLocation, Type dataToInsert){
        if (listNode==null){
            listNode = new LinkedListNode<>(dataToInsert);
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
