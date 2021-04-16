/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
 * connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * Constraints:
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 */
public class Problem141 {

    /**
     * Inner Node class to represent Linked List data structure
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to determine if linked list has a cycle
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param head
     * @return
     */
    private static boolean hasCycle(Node head) {
        if (head == null) { return false; }
        Node slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) { return true; }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node x1 = new Node(3);
        Node x2 = new Node(2);
        Node x3 = new Node(0);
        Node x4 = new Node(4);

        x1.next = x2;
        x2.next = x3;
        x3.next = x4;
        x4.next = x2;

        System.out.println(hasCycle(x1));
    }
}
