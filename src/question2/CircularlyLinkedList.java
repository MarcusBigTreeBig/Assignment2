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

    public void addNode (LinkedListNode newNode) {
        newNode.setNextNode(getCurrentNode().nextNode());
        getCurrentNode().setNextNode(newNode);
    }
    public void removeNextNode () {
        getCurrentNode().setNextNode(getCurrentNode().nextNode().nextNode());
    }
    public void moveToNextNode () {
        currentNode = currentNode.nextNode();
    }
    public LinkedListNode getCurrentNode () {
        return currentNode;
    }

}
