/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val ==
 * val, and return the new head.
 *
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 *
 * Example 2:
 * Input: head = [], val = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 10^4].
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 */
public class Problem203 {

    /**
     * Inner Node class to represent Linked List data structure
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to remove nodes which match given val
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param head
     * @param val
     * @return
     */
    private static Node removeElements(Node head, int val) {
        if (head == null) { return null; }
        Node pointer = head;

        while (pointer.next != null) {
            if (pointer.next.val == val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(6);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);

        head = removeElements(head, 6);
        for (Node x = head; x != null; x = x.next) {
            System.out.print(x.val + " ");
        }
    }
}
