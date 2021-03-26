/**
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
 * should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Follow up:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to
 * its next right node, just like in Figure B. The serialized output is in level order as connected by the next
 * pointers, with '#' signifying the end of each level.
 *
 * Constraints:
 *
 * The number of nodes in the given tree is less than 6000.
 * -100 <= node.val <= 100
 */
public class Problem117 {

    /**
     * Inner Node class for Tree data structure
     */
    private static class Node {
        int val;
        Node left, right, next;

        Node(int val) { this.val = val; }
    }

    /**
     * O(1) space complexity method to connect any given tree
     * The algo involves using the already populated next pointers in the subsequent levels of the tree.
     *
     * Time Complexity: O(n)
     *
     * @param root
     * @return
     */
    private static Node connect(Node root) {
        if (root == null) { return null; }
        Node leftmost = null, prevChild = null, curr = root;
        while (curr != null) {

            while (curr != null) {
                if (curr.left != null) {
                    if (leftmost == null) { leftmost = curr.left; }
                    if (prevChild != null) {
                        prevChild.next = curr.left;
                    }
                    prevChild = curr.left;
                }
                if (curr.right != null) {
                    if (leftmost == null) { leftmost = curr.right; }
                    if (prevChild != null) {
                        prevChild.next = curr.right;
                    }
                    prevChild = curr.right;
                }
                curr = curr.next;
            }

            curr = leftmost;
            prevChild = leftmost = null;
        }
        return root;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root = connect(root);
        System.out.println(root);
    }
}
