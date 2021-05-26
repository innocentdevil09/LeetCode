/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to
 * any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node
 * has its value set to the value of its corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in the original list and copied list
 * represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding
 * two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of
 * [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does
 * not point to any node.
 * Your code will only be given the head of the original linked list.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 * Example 4:
 * Input: head = []
 * Output: []
 * Explanation: The given linked list is empty (null pointer), so return null.
 *
 * Constraints:
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random is null or is pointing to some node in the linked list.
 */
public class Problem138 {

    /**
     * Inner Node class for LinkedList data structure
     */
    private static class Node {
        int val;
        Node next, random;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Iterative approach
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param head
     * @return
     */
    private static Node copyRandomList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node newNode = new Node(curr.val);
            newNode.next = next;
            curr.next = newNode;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            Node next = curr.next.next;
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = next;
        }

        Node dummy = new Node(-1);
        Node track = dummy;
        curr = head;
        while (curr != null) {
            Node next = curr.next.next;
            track.next = curr.next;
            track = track.next;
            track.next = null;
            curr.next = next;
            curr = curr.next;
        }
        return dummy.next;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n1.random = null;

        n2.next = n3;
        n2.random = n1;

        n3.next = n4;
        n3.random = n5;

        n4.next = n5;
        n4.random = n3;

        n5.next = null;
        n5.random = n1;

        Node node = copyRandomList(n1);
    }
}