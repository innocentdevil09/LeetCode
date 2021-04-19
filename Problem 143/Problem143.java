/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 5 * 10^4].
 * 1 <= Node.val <= 1000
 */
public class Problem143 {

    /**
     * Inner Node class for Linked List data structure
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Combination of three problems:
     * 1. Middle of linked list
     * 2. Reverse linked list
     * 3. Merge two linked list
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param head
     */
    private static void reorderList(Node head) {
        if (head == null || head.next == null) { return; }

        // Middle of linked list
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half of linked list
        Node preMid = slow;
        Node mid = slow.next;
        while (mid != null && mid.next != null) {
            Node curr = mid.next;
            mid.next = curr.next;
            curr.next = preMid.next;
            preMid.next = curr;
        }

        // Start re-ordering of linked list 1->2->3->6->5->4 to 1->6->2->5->3->4
        Node start = head;
        mid = preMid.next;
        while (mid != null && start != preMid) {
            preMid.next = mid.next;
            mid.next = start.next;
            start.next = mid;
            start = mid.next;
            mid = preMid.next;
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        reorderList(head);
        for (Node x = head; x != null; x = x.next) {
            System.out.print(x.val + " ");
        }
    }
}
