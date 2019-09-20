/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Problem24 {

    /**
     * Inner class to determine the Node data structure
     */
    private static class Node{
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to swap pairs in a given linked list
     *
     * @param head
     */
    private static Node swapPairs(Node head) {
        Node res = new Node(0);
        Node current = res;

        while (head != null && head.next != null) {
            current.next = new Node(head.next.val);
            current.next.next = new Node(head.val);

            current = current.next.next;
            head = head.next.next;
        }
        if (head != null) {
            current.next = new Node(head.val);
        }
        return res.next;
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

        Node newNode = swapPairs(head);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
    }
}
