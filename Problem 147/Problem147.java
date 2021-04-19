/**
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 *
 * The steps of the insertion sort algorithm:
 *
 * Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
 * 1. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within
 * the sorted list and inserts it there.
 * 2. It repeats until no input elements remain.
 * The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially
 * contains only the first element in the list. One element (red) is removed from the input data and inserted
 * in-place into the sorted list with each iteration.
 *
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 5000].
 * -5000 <= Node.val <= 5000
 */
public class Problem147 {

    /**
     * Inner Node class for Linked List data structure
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to perform insert sort on linked list
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * @param head
     * @return
     */
    private static Node insertionSortList(Node head) {
        Node dummy = new Node(-5001);
        Node curr = head;

        while (curr != null) {
            Node prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            Node next = curr.next;
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }
        return dummy.next;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(-1);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(0);

        head = insertionSortList(head);
        for (Node x = head; x != null; x = x.next) {
            System.out.print(x.val + " ");
        }
    }
}
