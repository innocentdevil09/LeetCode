/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class Problem19 {

    /**
     * Inner class to represent Node in a linked list
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to remove nth node from end in a given linked list
     * Algo:
     * 1. Use two pointers, slow and fast
     * 2. Increment fast ahead of slow by the number of count given by n
     * 3. Then increment both fast and slow till the fast pointer reach the end of linked list. Then you could change
     * the next pointer to remove the nth node in the linked list
     *
     * @param head
     * @param n
     */
    private static Node removeNthFromEmd(Node head, int n) {
        Node slow = head, fast = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (fast != null) {
            slow.next = slow.next.next;
        }
        return fast != null ? head : head.next;
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

        int n = 2;

        head = removeNthFromEmd(head, n);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
