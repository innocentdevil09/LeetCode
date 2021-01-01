/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class Problem83 {

    /**
     * Inner class to represent Node data structure for linked list
     */
    private static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to remove duplicates from linked list
     *
     * @param head
     * @return
     */
    private static Node deleteDuplicates(Node head) {
        for (Node x = head; x != null; x = x.next) {
            Node curr = x;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            x.next = curr.next;
        }
        return head;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);

        Node result = deleteDuplicates(head);
        for (Node x = result; x != null; x = x.next) {
            System.out.print(x.val + " | ");
        }
    }
}
