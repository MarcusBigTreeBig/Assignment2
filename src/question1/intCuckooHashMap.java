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
        return -1;
    }

    private void refactor () {

    }

    public void addElement (int element) {

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
