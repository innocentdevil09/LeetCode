/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 */
public class Problem61 {

    /**
     * Inner class for Node
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method for k-group traversal in singly linked-list
     *
     * @param head
     * @param k
     * @return
     */
    private static Node rotateRight(Node head, int k) {
        if (head == null) { return null; }

        Node curr = head;
        int len = 1;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        curr.next = head;
        k = k % len;
        curr = head;

        for (int i = 1; i < len - k; i++) {
            curr = curr.next;
        }

        Node result = curr.next;
        curr.next = null;
        return result;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = rotateRight(head, 2);
        while (result != null) {
            System.out.print(result.val + " | ");
            result = result.next;
        }
    }
}
