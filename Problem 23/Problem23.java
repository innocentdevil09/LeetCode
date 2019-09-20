/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class Problem23 {

    /**
     * Inner class to represent the Node data structure
     */
    private static class Node{
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to merge k number of sorted nodes together into a single linked list
     * Optimization:
     * By merging lists[0] & lists[1] into a single list, then lists[2] & lists[3] into a single list -- basically
     * using the principle of merge sort for this array optimizes the time complexity to a very great degree
     *
     * The comparison is with the method of combining two lists iteratively where one of them is the result node and
     * the other one keeps changing as we traverse the array
     *
     * Time reduced from 247 ms to 2 ms
     *
     * @param lists
     */
    private static Node mergeKNodes(Node[] lists) {
        if (lists == null || lists.length == 0) { return null; }

        while (lists.length > 1) {
            Node[] temp = new Node[(lists.length + 1) / 2];
            for (int i = 0; i < lists.length - 1; i += 2) {
                temp[i / 2] = mergeTwoNodes(lists[i], lists[i + 1]);
            }
            if (temp[temp.length - 1] == null) {
                temp[temp.length - 1] = lists[lists.length - 1];
            }
            lists = temp;
        }
        return lists[0];
    }

    /**
     * Method to merge two given sorted linked lists into a single linked list
     *
     * @param l1
     * @param l2
     */
    private static Node mergeTwoNodes(Node l1, Node l2) {
        Node head = new Node(0);
        Node current = head;

        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
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
        Node[] lists = new Node[3];

        Node n1 = new Node(1);
        n1.next = new Node(4);
        n1.next.next = new Node(5);

        Node n2 = new Node(1);
        n2.next = new Node(3);
        n2.next.next = new Node(4);

        Node n3 = new Node(2);
        n3.next = new Node(6);

        lists[0] = n1;
        lists[1] = n2;
        lists[2] = n3;

        Node head = mergeKNodes(lists);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
