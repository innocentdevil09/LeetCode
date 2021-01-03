/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class Problem92 {

    /**
     * Inner Node data structure to represent linked list
     */
    private static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to reverse linked list between two index m & n
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static Node reverseBetween(Node head, int m, int n) {
        Node prev = null, mNode = head;
        for (int counter = 1; counter < n; counter++) {
            if (counter < m) {
                prev = mNode;
                mNode = mNode.next;
            } else {
                if (prev == null) {
                    prev = new Node(0);
                    prev.next = mNode;
                    head = null;
                }
                Node nextNode = mNode.next;
                mNode.next = nextNode.next;
                nextNode.next = prev.next;
                prev.next = nextNode;
            }
        }
        return head == null ? prev.next : head;
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

        int m = 2, n = 4;
        Node res = reverseBetween(head, m, n);
        for (Node x = res; x != null; x = x.next) {
            System.out.print(x.val + " | ");
        }
    }
}
