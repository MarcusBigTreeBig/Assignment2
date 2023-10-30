package question2;

public class Main {

    /**
     * sets up test cases and tests if the linked list and recursive algorithms for the Josephus problem output the same answers
     *
     * @param args
     */
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
         //adding the last person first, so that the first time removeNextNode() is called, it kills the first person
         for (int i = 1; i <= n-1; i++) {
             circle.addNode(new LinkedListNode(i, null));
             circle.moveToNextNode();
         }
         circle.currentToHead();
         circle.removeNextNode();//killing the first person
         for (int i = 0; i < n-2; i++) {
             for (int j = 0; j < k; j++) {//stops one before the person to kill
                 circle.moveToNextNode();
             }
             circle.removeNextNode();
         }
         return ((Integer) circle.getCurrentNode().getValue()).intValue();
    }

    /**
     * Algorithm to solve the Josephus problem using a recursive formula
     * used to verify the linked list approach
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

    /**
     * Takes an array of test values to compare the linked list algorithm for the Josephus problem to a recursive algorithm
     * Prints both inputs, each result, and if they are equal for each case
     * If the amount of test values for the 2 inputs are the same, nothing will happen
     *
     * @param nTestValues array of test values for the amount of people in the circle
     * @param kTestValues array of test values for the amount of people skipped at a time
     */
    public static void runTests (int[] nTestValues, int[] kTestValues) {
        if (nTestValues.length == kTestValues.length) {
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

}

/*
Output:

n: 1; k: 1; LinkedList: 1; Recursive: 1; Test: true
n: 14; k: 1; LinkedList: 12; Recursive: 12; Test: true
n: 450; k: 20; LinkedList: 426; Recursive: 426; Test: true
n: 20; k: 450; LinkedList: 3; Recursive: 3; Test: true
n: 20; k: 0; LinkedList: 20; Recursive: 20; Test: true
n: 5; k: 3; LinkedList: 3; Recursive: 3; Test: true
n: 7; k: 3; LinkedList: 6; Recursive: 6; Test: true
 */