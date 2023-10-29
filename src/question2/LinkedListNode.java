package question2;

/**
 * A single node for a linked list
 * Has a value that can be any object
 * Has a pointer to another node
 */

public class LinkedListNode {

    private LinkedListNode next;
    private Object value;

    /**
     * Constructs a node with a value and a pointer to another node
     *
     * @param value the value of the node
     * @param nextNode the pointer to the next node
     */
    public LinkedListNode (int value, LinkedListNode nextNode) {
        setValue(value);
        setNextNode(nextNode);
    }

    public LinkedListNode nextNode () {
        return next;
    }
    public Object getValue() {
        return value;
    }
    public void setNextNode (LinkedListNode node) {
        next = node;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
