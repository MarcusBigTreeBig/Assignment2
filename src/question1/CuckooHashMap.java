package question1;

/**
 * Implements a hash map using cuckoo hashing
 * Each element given is stored with the key it's inputted with, and can then be searched up by that key
 */
public class CuckooHashMap {
    private Element[] table;

    /**
     * creates a map with a starting size
     *
     * @param startSize
     */
    public CuckooHashMap(int startSize) {
        table = new Element[startSize];
    }

    /**
     * 2 hashing functions, based on if wanting to use the second function or not for cuckoo hashing
     * function is dependent on size of hash table, so when hash table is refactored, so is the function
     *
     * @param key key being hashed
     * @param secondFunction true if using second function, false if using first function
     * @return hash value
     */
    private int hashFunction (int key, boolean secondFunction) {
        int second = 0;
        if (secondFunction) {
            second = 1;
        }
        return ((key%table.length) - (table.length-1)*second)*(int)Math.pow(-1, second);
    }


    /**
     * refactors the table to avoid an infinite loop
     */
    private void refactor () {
        Element[] oldTable = table;
        table = new Element[2*oldTable.length];
        for (Element n: oldTable) {
            if (n != null) {
                addElement(n, n.key);
            }
        }
    }

    /**
     * adds an element to the hash table
     * if can't place in either of the hash functions, refactors the table
     *
     * @param value value of the element
     * @param key key of the element
     */
    public void addElement (Object value, int key) {
        Element element = new Element(value, key);
        Element originalElement = element;
        Element nextElement;
        boolean complete = false;
        if (elementAtKey(key) != null) {
            removeElementAtKey(key);
        }
        do {
            do {
                if (table[hashFunction(element.key, false)] == null) {
                    table[hashFunction(element.key, false)] = element;
                    complete = true;
                } else if (table[hashFunction(element.key, true)] == null) {
                    table[hashFunction(element.key, true)] = element;
                    complete = true;
                } else {
                    nextElement = table[hashFunction(key, false)];
                    table[hashFunction(element.key, false)] = element;
                    element = nextElement;
                }
            } while (!complete && element != originalElement);
            if (!complete) {
                refactor();
            }
        } while (!complete);
    }

    /**
     * removes the element at the given key
     *
     * @param key
     */
    public void removeElementAtKey (int key) {
        if (table[hashFunction(key, false)] != null && table[hashFunction(key, false)].key == key) {
            table[hashFunction(key, false)] = null;
        }
        if (table[hashFunction(key, true)] != null && table[hashFunction(key, true)].key == key) {
            table[hashFunction(key, true)] = null;
        }
    }

    /**
     *
     * @param key
     * @return the value of the element at the inputted key
     */
    public Object elementAtKey (int key) {
        if (table[hashFunction(key, false)] != null && table[hashFunction(key, false)].key == key) {
            return table[hashFunction(key, false)].value;
        }
        else if (table[hashFunction(key, true)] != null && table[hashFunction(key, true)].key == key) {
            return table[hashFunction(key, true)].value;
        }else{
            return null;
        }
    }

    public String toString () {
        String s = "";
        for (Element e: table) {
            if (e != null) {
                s += e.value.toString() + "";
            }else{
                s += " . ";
            }
        }
        return s;
    }

    /**
     * stores the given value and key as a single element
     */
    private class Element {
        Object value;
        int key;
        Element (Object value, int key) {
            this.value = value;
            this.key = key;
        }
        public String toString () {
            return value.toString();
        }
    }
}
