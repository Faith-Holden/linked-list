public class LinkedListNode <Type>{
    public LinkedListNode(Type dataForList){
        data = dataForList;
    }
    public LinkedListNode(Type copyListData, LinkedListNode<Type> copyListNext){
        this.data = copyListData;
        this.nextItem = copyListNext;
    }

    private Type data;
    public LinkedListNode<Type> nextItem = null;
    int numberOfItemsInList = 1;


    void appendToList (Type dataToAppend){
        insertItem(numberOfItemsInList, dataToAppend);
    }

    Type getItem (int itemLocation){
        LinkedListNode<Type> tempList;
        int counter = 0;
        if (itemLocation ==0){
            return data;
        }
        tempList = nextItem;
        counter++;
        while (counter<itemLocation && tempList.nextItem!=null){
            tempList = tempList.nextItem;
            counter++;
        }
        return tempList.data;
    }

    void printList (){
        LinkedListNode<Type> tempList;
        System.out.println(data);
        tempList = nextItem;
        while (tempList!=null){
            System.out.println(tempList.data);
            tempList = tempList.nextItem;

        }
    }

    int getLength (){
        return numberOfItemsInList;
    }

    void insertItem (int insertLocation, Type dataToInsert){
        LinkedListNode<Type> holdListPt1 = new LinkedListNode<>(data, nextItem);
        if (insertLocation!=0){
            holdListPt1 = this;
            int locationCounter = 0;
            while (locationCounter<insertLocation-1){
                holdListPt1 = holdListPt1.nextItem;
                locationCounter++;
            }
            holdListPt1.nextItem = new LinkedListNode<>(dataToInsert, holdListPt1.nextItem);
        }
        else{
            data = dataToInsert;
            nextItem = holdListPt1;
        }
        numberOfItemsInList++;
    }

    void deleteItem (int deleteLocation){
        int counter = 0;
        LinkedListNode<Type> holdList = new LinkedListNode<>(data, nextItem);
        if (deleteLocation==0){
            data = nextItem.data;
            nextItem = nextItem.nextItem;
        }
        else{
            while (counter < deleteLocation-1){
                holdList = holdList.nextItem;
                counter++;
            }
            holdList.nextItem = holdList.nextItem.nextItem;
        }
        numberOfItemsInList--;
    }
}
