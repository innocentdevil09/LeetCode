/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Problem206 {

    /**
     * Inner Node class to represent Linked List
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) { this.val = val; }
    }

    /**
     * Iterative approach tp reverse linked list
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param head
     * @return
     */
    private static Node reverseList(Node head) {
        if (head == null) { return null; }
        Node prev = null, curr = head;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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

        head = reverseList(head);
        for (Node x = head; x != null; x = x.next) {
            System.out.print(x.val + " ");
        }
    }
}
