import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not
 * a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class Problem25 {

    /**
     * Inner class to represent data structure of Node in linked list
     */
    private static class Node{
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to reverse k elements in the given linked list. If the number of elements is less than k, then the
     * order of the elements remain the same
     *
     * @param head
     * @param k
     */
    private static Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null) { return head; }

        Node res = new Node(0);
        Node current = res;
        List<Integer> temp = new ArrayList<>();

        while (head != null) {
            Node pointer = head;
            for (int i = 0; i < k && pointer != null; i++) {
                temp.add(pointer.val);
                pointer = pointer.next;
            }

            if (temp.size() < k) {
                current.next = head;
            } else {
                for (int i = k - 1; i >= 0; i--) {
                    current.next = new Node(temp.get(i));
                    current = current.next;
                }
            }
            head = pointer;
            temp.clear();
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
        head.next.next.next.next = new Node(5);

        int k = 3;

        Node result = reverseKGroup(head, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
