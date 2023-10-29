package question2;

import java.util.ArrayList;

public class CircularlyLinkedList {

    private LinkedListNode headNode;
    private LinkedListNode currentNode;

    public CircularlyLinkedList (LinkedListNode headNode) {
        this.headNode = headNode;
        this.headNode.setNextNode(this.headNode);
        this.currentNode = currentNode;
    }

    public void addNode () {

    }
    public void removeNode () {

    }
    public void moveToNextNode () {

    }
    public LinkedListNode getCurrentNode () {
        return currentNode;
    }

}
