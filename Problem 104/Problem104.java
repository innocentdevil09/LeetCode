/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Example 3:
 * Input: root = []
 * Output: 0
 *
 * Example 4:
 * Input: root = [0]
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class Problem104 {

    /**
     * Inner Node class for Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to return maximum depth of the tree
     *
     * @param root
     * @return
     */
    private static int maxDepth(Node root) {
        return traversal(root, 0);
    }

    /**
     * Method to keep a track of the level of each node, return its depth back to its parent
     *
     * @param x
     * @param level
     * @return
     */
    private static int traversal(Node x, int level) {
        if (x == null) { return level; }

        int n1 = traversal(x.left, level + 1);
        int n2 = traversal(x.right, level + 1);
        return Math.max(n1, n2);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(maxDepth(root));
    }
}
