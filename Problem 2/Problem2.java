/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Problem2 {

    /**
     * Class to represent each node in the linked list
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to add two given numbers as linked list
     * Algo:
     * 1. Add the two numbers just like elementary math
     * 2. Keep a pointer of the carry
     * 3. Keep a pointer to the head node and add to the linked list as long as both the given inputs are not totally
     * traversed till the end
     * 4. Add a new node to the end if there is a carryover from the addition
     *
     * @param head1
     * @param head2
     */
    private static Node addTwoNumbers(Node head1, Node head2) {
        int carry = 0;
        Node result = new Node(-1);
        Node current = result;
        while (head1 != null || head2 != null) {
            int sum = (head1 != null ? head1.val : 0) + (head2 != null ? head2.val : 0) + carry;
            Node newNode = new Node(sum % 10);
            carry = sum / 10;

            current.next = newNode;
            current = newNode;
            if (head1 != null) { head1 = head1.next; }
            if (head2 != null) { head2 = head2.next; }
        }
        if (carry > 0) {
            current.next = new Node(carry);
        }
        return result.next;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(3);

        Node node2 = new Node(5);
        node2.next = new Node(6);
        node2.next.next = new Node(4);

        Node result = addTwoNumbers(node1, node2);
        Node current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
