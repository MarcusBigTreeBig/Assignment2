package question1;

public class intCuckooHashMap {
    private int[] table;
    private int amountStored;

    public intCuckooHashMap (int startSize) {
        table = new int[startSize];
    }

    private int hashFunction (int key, boolean secondFunction) {
        int second = 0;
        if (secondFunction) {
            second = 1;
        }
        return ((key%table.length) - table.length*second)*(int)Math.pow(-1, second);
    }
    private int locateElement (int element) {
        if (table[hashFunction(element, false)] == element) {
            return hashFunction(element, false);
        }
        else if (table[hashFunction(element, true)] == element) {
            return hashFunction(element, true);
        }
        else {
            return -1;
        }
    }

    private void refactor () {
        int[] oldTable = table;
        table = new int[2*oldTable.length];
        for (int n: oldTable) {
            if (n != 0) {
                addElement(n);
            }
        }
    }

    public void addElement (int element) {
        int originalElement = element;
        int nextElement;
        boolean complete = false;
        do {
            do {
                if (table[hashFunction(element, false)] == 0) {
                    table[hashFunction(element, false)] = element;
                    complete = true;
                } else if (table[hashFunction(element, true)] == 0) {
                    table[hashFunction(element, true)] = element;
                    complete = true;
                } else {
                    nextElement = table[hashFunction(element, false)];
                    table[hashFunction(element, false)] = element;
                    element = nextElement;
                }
            } while (!complete && element != originalElement);
            if (!complete) {
                refactor();
            }
        } while (!complete);
    }
    public boolean searchElement (int element) {
        if (locateElement(element) > 0) {
            return true;
        }else{
            return false;
        }
    }
    public void removeElement (int element) {
        if (searchElement(element)) {
            table[locateElement(element)] = 0;
        }
    }
}
