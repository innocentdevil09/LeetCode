/**
 * Problem Statement:
 * ------------------
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    /**
     * Method to add two given numbers as linked list
     * Algo:
     * 1. Add the two numbers just like elementary math
     * 2. Keep a pointer of the carry
     * 3. Keep a pointer to the head node and add to the linked list as long as both the given inputs are not totally
     * traversed till the end
     * 4. Add a new node to the end if there is a carryover from the addition
     *
     * @param l1
     * @param l2
     */
    public Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        Node head = null, pointer = null;

        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;

            carry = sum / 10;
            Node node = new Node(sum % 10);
            if (head == null) { head = node; }
            if (pointer != null) { pointer.next = node; }
            pointer = node;

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if (carry > 0) {
            pointer.next = new Node(carry);
        }
        return head;
    }

    /**
     * Class to represent each node in the linked list
     */
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
