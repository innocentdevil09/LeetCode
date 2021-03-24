/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the
 * list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 *
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class Problem114 {

    /**
     * Inner Node class for Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to convert given tree into linked list. The order should be same as pre-order traversal
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root
     */
    private static void flatten(Node root) {
        flattenTree(root);
    }

    /**
     * Recursive call to flatten the given tree and return its tail
     *
     * @param x
     * @return
     */
    private static Node flattenTree(Node x) {
        if (x == null) { return null; }
        if (x.left == null && x.right == null) {
            return x;
        }
        Node leftTail = flattenTree(x.left);
        Node rightTail = flattenTree(x.right);
        if (leftTail != null) {
            leftTail.right = x.right;
            x.right = x.left;
            x.left = null;
        }
        return rightTail != null ? rightTail : leftTail;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        flatten(root);
        System.out.println(root);
    }
}
