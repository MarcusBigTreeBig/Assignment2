package question2;

/**
 * A linked list that contains nodes that have a value and a pointer to the next node
 * The nodes will always point to each other in a circular pattern
 */

public class CircularlyLinkedList{

    private LinkedListNode headNode;
    private LinkedListNode currentNode;

    /**
     * creates a CircularlyLinkedList with a single element
     * the element will be the head node of the list
     * the element will point to itself
     *
     * @param headNode the head node
     */
    public CircularlyLinkedList (LinkedListNode headNode) {
        this.headNode = headNode;
        this.headNode.setNextNode(this.headNode);
        this.currentNode = this.headNode;
    }

    /**
     * adds a node to the list
     * places the node after the current one being read
     *
     * @param newNode
     */
    public void addNode (LinkedListNode newNode) {
        newNode.setNextNode(getCurrentNode().nextNode());
        getCurrentNode().setNextNode(newNode);
    }

    /**
     * removes the node following the node being currently read
     */
    public void removeNextNode () {
        getCurrentNode().setNextNode(getCurrentNode().nextNode().nextNode());
    }

    /**
     * reads the node after the one being currently read
     */
    public void moveToNextNode () {
        currentNode = currentNode.nextNode();
    }

    /**
     * sets the node currently being read to the head node
     */
    public void currentToHead () {currentNode = headNode;}

    /**
     *
     * @return the node the list is currently reading
     */
    public LinkedListNode getCurrentNode () {
        return currentNode;
    }

}
