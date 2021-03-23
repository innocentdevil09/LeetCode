/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */
public class Problem111 {

    /**
     * Inner Node class for Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to fetch minimum depth of the tree
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root
     * @return
     */
    private static int minDepth(Node root) {
        if (root == null) { return 0; }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
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

        System.out.println(minDepth(root));
    }
}
