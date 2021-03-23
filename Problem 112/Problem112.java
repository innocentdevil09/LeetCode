/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 *
 * Example 3:
 * Input: root = [1,2], targetSum = 0
 * Output: false
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Problem112 {

    /**
     * Inner Node class for Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to determine if the path from root to leaf node, sum of all elements equals target
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root
     * @param targetSum
     * @return
     */
    private static boolean hasPathSum(Node root, int targetSum) {
        if (root == null) { return false; }
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);

        System.out.println(hasPathSum(root, 22));
    }
}
