package question2;

public class Main {
    public static void main (String[] args) {
        int[] nTestValues = {1, 14, 450, 20, 20, 5, 7};
        int[] kTestValues = {1, 1, 20, 450, 0, 3, 3};
        runTests(nTestValues, kTestValues);
    }

    /**
     * Algorithm to solve the Josephus problem using a circularly linked list
     *
     * @param n amount of people in the circle
     * @param k how many people are skipped before another is killed
     * @return the place in the initial circle that survives
     */
    public static int josephus (int n, int k) {
         CircularlyLinkedList circle = new CircularlyLinkedList(new LinkedListNode(n, null));
         //adding the last person first, so that teh first time removeNextNode() is called, it kills the first person
         for (int i = 1; i <= n-1; i++) {
             circle.addNode(new LinkedListNode(i, null));
         }
         circle.removeNextNode();//killing the first person
         for (int i = 0; i < n-2; i++) {
             for (int j = 0; j < k-1; j++) {//stops one before the person to kill
                 circle.moveToNextNode();
             }
             circle.removeNextNode();
         }
         return ((Integer) circle.getCurrentNode().getValue()).intValue();
    }

    /**
     * Algorithm to solve the Josephus problem using a recursive formula
     *
     * @param n amount of people in the circle
     * @param k how many people are skipped before another is killed
     * @return the place in the initial circle that survives
     */
    public static int josephusTest (int n, int k) {
        if (n == 1) {
            return 1;
        }else{
            return ((josephusTest(n-1, k)+k-1)%(n-1))+2;
        }
    }

    public static void runTests (int[] nTestValues, int[] kTestValues) {
        int n, k, linkedList, recursive;
        for (int i = 0; i < nTestValues.length; i++) {
            n = nTestValues[i];
            k = kTestValues[i];
            linkedList = josephus(n, k);
            recursive = josephusTest(n, k);
            System.out.println("n: " + n + "; k: " + k + "; LinkedList: " + linkedList + "; Recursive: " + recursive + "; Test: " + (linkedList == recursive));
        }
    }

}
