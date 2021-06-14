/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class Problem234 {

    /**
     * Inner Node class to represent Linked list data structure
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) { this.val = val; }
    }

    /**
     * Combining various methods to check in O(N) time
     * Get mid node, reverse the latter part, check all vals, reverse the latter part again to maintain structure
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param head
     * @return
     */
    private static boolean isPalindrome(Node head) {
        if (head == null) { return true; }

        Node mid = getMid(head);
        Node reverse = reverse(mid.next);

        boolean result = true;
        for (Node x1 = head, x2 = reverse; x1 != null && x2 != null; x1 = x1.next, x2 = x2.next) {
            if (x1.val != x2.val) { result = false; break; }
        }
        mid.next = reverse(reverse);
        return result;
    }

    /**
     * Method to get mid node of given linked list
     *
     * @param x
     * @return
     */
    private static Node getMid(Node x) {
        Node slow = x;
        Node fast = x.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Method to reverse given linked list
     *
     * @param start
     * @return
     */
    private static Node reverse(Node start) {
        Node prev = null;
        Node curr = start;

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
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        System.out.println(isPalindrome(head));
    }
}
