package Main;

public class LinkedListNode <Type>{
    public LinkedListNode(Type dataForList){
        data = dataForList;
    }
    public LinkedListNode(Type copyListData, LinkedListNode<Type> copyListNext){
        this.data = copyListData;
        this.nextNode = copyListNext;
    }

    Type data;
    public LinkedListNode<Type> nextNode = null;
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
        tempList = nextNode;
        counter++;
        while (counter<itemLocation && tempList.nextNode !=null){
            tempList = tempList.nextNode;
            counter++;
        }
        return tempList.data;
    }

    @Override
    public String toString (){
        StringBuilder buildListString = new StringBuilder();
        LinkedListNode<Type>  currentList = this;

        while (currentList.nextNode!=null){
            buildListString.append(currentList.data.toString());
            buildListString.append("\n");
            currentList = currentList.nextNode;
        }

        buildListString.append(currentList.data.toString());
        return buildListString.toString();
    }

    int getLength (){
        return numberOfItemsInList;
    }

    void insertItem (int insertLocation, Type dataToInsert){
        LinkedListNode<Type> holdListPt1 = new LinkedListNode<>(data, nextNode);
        if (insertLocation!=0){
            holdListPt1 = this;
            int locationCounter = 0;
            while (locationCounter<insertLocation-1){
                holdListPt1 = holdListPt1.nextNode;
                locationCounter++;
            }
            holdListPt1.nextNode = new LinkedListNode<>(dataToInsert, holdListPt1.nextNode);
        }
        else{
            data = dataToInsert;
            nextNode = holdListPt1;
        }
        numberOfItemsInList++;
    }

    void deleteItem (int deleteLocation){
        int counter = 0;
        LinkedListNode<Type> holdList = new LinkedListNode<>(data, nextNode);
        if (deleteLocation==0){
            data = nextNode.data;
            nextNode = nextNode.nextNode;
        }
        else{
            while (counter < deleteLocation-1){
                holdList = holdList.nextNode;
                counter++;
            }
            holdList.nextNode = holdList.nextNode.nextNode;
        }
        numberOfItemsInList--;
    }
}
