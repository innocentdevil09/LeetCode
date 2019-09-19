/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
 * nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Problem21 {

    /**
     * Ineer class to represent data structure of Node
     */
    private static class Node{
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to merge two sorted linked lists into a single linked list
     *
     * @param n1
     * @param n2
     */
    private static Node mergeTwoLists(Node n1, Node n2) {
        Node head = new Node(0);
        Node current = head;

        while (n1 != null || n2 != null) {
            if (n2 == null || (n1 != null && n1.val < n2.val)) {
                current.next = n1;
                n1 = n1.next;
            } else {
                current.next = n2;
                n2 = n2.next;
            }
            current = current.next;
        }
        return head.next;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(4);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        Node head = mergeTwoLists(l1, l2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
