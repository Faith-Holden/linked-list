package Main;

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
        BidirectionalListNode<Type> nodeToInsert = new BidirectionalListNode<> (dataToInsert);
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
                setNewConnection(currentList, nodeToInsert);
            }
            else{
                BidirectionalListNode<Type>  pt2ofCurrentList = currentList.nextNode;
                setNewConnection(nodeToInsert, pt2ofCurrentList);
                setNewConnection(currentList, nodeToInsert);
            }
        }
        else {
            setNewConnection(nodeToInsert, currentList);
        }


        numberOfItemsInList++;
    }

    void appendToList (Type  dataToAppend){


        BidirectionalListNode<Type>  nodeToInsert = new BidirectionalListNode <Type> (dataToAppend);
        BidirectionalListNode<Type>  currentList = this;
        while (currentList.nextNode!=null){
            currentList = currentList.nextNode;
        }
        setNewConnection(currentList, nodeToInsert);
        numberOfItemsInList++;
    }

    Type  getItem (int itemLocation){
        int counter = 0;
        BidirectionalListNode <Type> currentList = this;
        while(currentList.previousNode!=null){
            currentList = currentList.previousNode;
        }
        while (counter<itemLocation){
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
            this.nextNode = currentList.nextNode;
            this.nodeData = currentList.nodeData;

        }
        else {
            while (counter<deleteLocation-1){
                currentList = currentList.nextNode;
                counter++;
            }
            if (currentList.nextNode.nextNode==null){
                currentList.nextNode=null;
            }
            else {
                setNewConnection(currentList, currentList.nextNode.nextNode);
            }
        }
        numberOfItemsInList--;
    }


    @Override
    public String toString(){
        StringBuilder buildListString = new StringBuilder();
        BidirectionalListNode<Type>  currentList = this;

        while(currentList.previousNode!=null){
            currentList = currentList.previousNode;
        }
        while (currentList.nextNode!=null){
            buildListString.append(currentList.nodeData.toString());
            buildListString.append("\n");
            currentList = currentList.nextNode;
        }

        buildListString.append(currentList.nodeData.toString());
        return buildListString.toString();
    }

    private void setNewConnection (BidirectionalListNode<Type> firstConnectionNode, BidirectionalListNode<Type> secondConnectionNode){

            firstConnectionNode.nextNode = secondConnectionNode;
            secondConnectionNode.previousNode = firstConnectionNode;
    }



}
