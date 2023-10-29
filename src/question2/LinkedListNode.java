package question2;

public class LinkedListNode {

    private LinkedListNode next;
    private Object value;

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
