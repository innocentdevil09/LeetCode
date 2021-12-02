/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
 * even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 *
 * Example 2:
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 *
 * Constraints:
 * n == number of nodes in the linked list
 * 0 <= n <= 10^4
 * -10^6 <= Node.val <= 10^6
 */
public class Problem328 {

    /**
     * Inner static class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to shuffle given linked list such that all nodes at odd indexes are clubbed together, while maintaining
     * the order
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * @param head
     * @return
     */
    private static Node oddEvenList(Node head) {
        if (head == null) { return head; }

        Node odd = head, even = head.next;
        Node prev = head.next;
        while (prev != null) {
            Node curr = prev.next;
            if (curr == null) { break; }

            Node next = curr.next;
            odd.next = curr;
            curr.next = even;
            prev.next = next;

            odd = odd.next;
            prev = prev.next;
        }
        return head;
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
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);

        head = oddEvenList(head);
        for (Node x = head; x != null; x = x.next) {
            System.out.print(x.val + " ");
        }
    }
}
