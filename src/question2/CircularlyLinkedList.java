package question2;

public class CircularlyLinkedList {

    private LinkedListNode headNode;
    private LinkedListNode currentNode;

    public CircularlyLinkedList (LinkedListNode headNode) {
        this.headNode = headNode;
        this.headNode.setNextNode(this.headNode);
        this.currentNode = this.headNode;
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
