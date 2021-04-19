/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 5 * 10^4].
 * -10^5 <= Node.val <= 10^5
 */
public class Problem148 {

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
     * Merge Sort
     *
     * Time Complexity: O(N logN)
     * Space Complexity: O(logN)
     *
     * @param head
     * @return
     */
    private static Node sortList(Node head) {
        if (head == null || head.next == null) { return head; }

        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);

        return merge(left, right);
    }

    /**
     * Method to merge two linked lists
     *
     * @param list1
     * @param list2
     * @return
     */
    private static Node merge(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    /**
     * Method to get mid node of linked list
     *
     * @param head
     * @return
     */
    private static Node getMid(Node head) {
        Node prevMid = null;
        while (head != null && head.next != null) {
            prevMid = (prevMid == null) ? head : prevMid.next;
            head = head.next.next;
        }
        Node mid = prevMid.next;
        prevMid.next = null;
        return mid;
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
        head.next.next.next.next.next = new Node(2);

        head = sortList(head);
        for (Node x = head; x != null; x = x.next) {
            System.out.print(x.val + " ");
        }
    }
}
