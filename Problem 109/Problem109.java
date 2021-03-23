/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height
 * balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 *
 * Example 1:
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 *
 * Example 2:
 * Input: head = []
 * Output: []
 *
 * Example 3:
 * Input: head = [0]
 * Output: [0]
 *
 * Example 4:
 * Input: head = [1,3]
 * Output: [3,1]
 *
 * Constraints:
 *
 * The number of nodes in head is in the range [0, 2 * 104].
 * -10^5 <= Node.val <= 10^5
 */
public class Problem109 {

    /**
     * Inner TreeNode class to represent Tree data structure
     */
    private static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Inner ListNode class to represent LinkedList data structure
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Pointer to node in linked list
     */
    private static ListNode start = null;

    /**
     * Efficient way to convert sorted linked list into tree
     * The challenge with linked list is to access elements within the list, much easier with array
     * Algo: Keep a pointer to head of the linked list, and proceed with left and right child using recursive stack
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param head
     * @return
     */
    private static TreeNode sortedListToBST(ListNode head) {
        int len = getLength(head);
        start = head;
        return buildTree(0, len - 1);
    }

    /**
     * Recursive method to build tree and assign left & right child elements to the root
     *
     * @param lo
     * @param hi
     * @return
     */
    private static TreeNode buildTree(int lo, int hi) {
        if (lo > hi) { return null; }

        int mid = lo + (hi - lo) / 2;
        TreeNode left = buildTree(lo, mid - 1);
        TreeNode root = new TreeNode(start.val);
        root.left = left;
        start = start.next;

        root.right = buildTree(mid + 1, hi);
        return root;
    }

    /**
     * Method to fetch number of elements in linked list
     *
     * @param head
     * @return
     */
    private static int getLength(ListNode head) {
        int size = 0;
        for (ListNode x = head; x != null; x = x.next) {
            size++;
        }
        return size;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);
        System.out.println(root);
    }
}
