public class BidirectionalListNode <Type>{
    public BidirectionalListNode(Type dataForNode){
        nodeData = dataForNode;
    }
    public Type nodeData;
    public BidirectionalListNode<Type>  nextNode = null;
    public BidirectionalListNode<Type>  previousNode = null;
    int numberOfItemsInList = 1;


    void insertItem(int insertLocation, Type dataToInsert){
        int counter = 0;
        BidirectionalListNode<Type> nodeToInsert = new BidirectionalListNode<Type> (dataToInsert);
        BidirectionalListNode<Type>  currentList = this;
        while(currentList.previousNode!=null){
            currentList = currentList.previousNode;
        }

        if (insertLocation!=0){
            while (counter<insertLocation-1){
                currentList = currentList.nextNode;
                counter++;
            }
            if (currentList.nextNode==null){
                setNewConnection(currentList, nodeToInsert, true);
            }
            else{
                BidirectionalListNode<Type>  pt2ofCurrentList = currentList.nextNode.nextNode;
                setNewConnection(pt2ofCurrentList, nodeToInsert, false);
                setNewConnection(currentList, pt2ofCurrentList, true);
            }
        }
        else {
            setNewConnection(currentList, nodeToInsert, false);
        }

        numberOfItemsInList++;
    }

    void appendToList (Type  dataToAppend){
        BidirectionalListNode<Type>  nodeToInsert = new BidirectionalListNode <Type> (dataToAppend);
        BidirectionalListNode<Type>  currentList = this;
        while (currentList.nextNode!=null){
            currentList = currentList.nextNode;
        }
        setNewConnection(currentList, nodeToInsert, true);
        numberOfItemsInList++;
    }

    Type  getItem (int itemLocation){
        int counter = 0;
        BidirectionalListNode <Type> currentList = this;
        while(currentList.previousNode!=null){
            currentList = currentList.previousNode;
        }
        while (counter<itemLocation-1){
            currentList = currentList.nextNode;
            counter++;
        }
        return currentList.nodeData;

    }

    int getLength (){
        return numberOfItemsInList;
    }

    void deleteItem (int deleteLocation){
        int counter = 0;

        BidirectionalListNode<Type>  currentList = this;
        while(currentList.previousNode!=null){
            currentList = currentList.previousNode;
        }

        if(deleteLocation==0){
            currentList = currentList.nextNode;
            currentList.previousNode=null;
        }
        else {
            while (counter<deleteLocation-2){
                currentList = currentList.nextNode;
                counter++;
            }
            if (currentList.nextNode.nextNode==null){
                currentList.nextNode=null;
            }
            else {
                setNewConnection(currentList, currentList.nextNode.nextNode, true);
            }
        }
        numberOfItemsInList--;
    }

    void printList (){
        BidirectionalListNode<Type>  currentList = this;
        while(currentList.previousNode!=null){
            currentList = currentList.previousNode;
        }
        while (currentList.nextNode!=null){
            System.out.println(currentList.nodeData);
            currentList = currentList.nextNode;
        }
        System.out.println(currentList.nodeData);
    }

    private void setNewConnection (BidirectionalListNode<Type>  originalNode, BidirectionalListNode<Type> newConnectionNode, boolean isOriginalEarlier){

        if (isOriginalEarlier){
            originalNode.nextNode = newConnectionNode;
            newConnectionNode.previousNode = originalNode;
        }
        else {
            originalNode.previousNode = newConnectionNode;
            newConnectionNode.nextNode = originalNode;
        }
    }



}
