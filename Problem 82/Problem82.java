/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 *
 * Return the linked list sorted as well.
 *
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class Problem82 {

    /**
     * Inner class to represent Node in linked list
     */
    private static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to entire remove elements which are duplicates in the linked list
     * This is slightly different from removing the duplicates, in the sense that if a number is found to be occurring
     * more than once -- we want it out of the list altogether
     *
     * @param head
     * @return
     */
    private static Node deleteDuplicates(Node head) {
        Node prev = null, x = head;
        while (x != null) {
            Node curr = x;
            if (x.next != null && x.val == x.next.val) {
                while (x != null && x.val == curr.val) {
                    x = x.next;
                }
                if (x != null) { continue; }
            }
            if (prev == null) {
                head = x;
            } else {
                prev.next = x;
            }
            prev = x;
            if (x != null) { x = x.next; }
        }
        return head;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(5);

        Node res = deleteDuplicates(head);
        for (Node x = res; x != null; x = x.next) {
            System.out.print(x.val + " | ");
        }
    }
}
