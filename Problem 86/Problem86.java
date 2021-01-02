/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class Problem86 {

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
     * A much better approach.
     * We create two lists before and after to keep the elements with val < x & val >= x. And then join them together
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * We have not utilized any extra space, the point to note is that we are reforming the original list, by moving
     * the original nodes, we have not used any extra space as such
     *
     * @param head
     * @param x
     * @return
     */
    private static Node partition(Node head, int x) {
        Node beforePartition = new Node(0);
        Node before = beforePartition;
        Node afterPartition = new Node(0);
        Node after = afterPartition;

        for (; head != null; head = head.next) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
        }
        after.next = null;
        before.next = afterPartition.next;
        return beforePartition.next;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);

        Node result = partition(head, 3);
        for (Node x = result; x != null; x = x.next) {
            System.out.print(x.val + " | ");
        }
    }
}
