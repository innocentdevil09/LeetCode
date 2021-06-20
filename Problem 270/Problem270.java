/**
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
 *
 * Example 1:
 * Input: root = [4,2,5,1,3], target = 3.714286
 * Output: 4
 *
 * Example 2:
 * Input: root = [1], target = 4.428571
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * 0 <= Node.val <= 10^9
 * -10^9 <= target <= 10^9
 */
public class Problem270 {

    /**
     * Inner Node class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to fetch Node with the closest value
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root
     * @param target
     * @return
     */
    private static int closestValue(Node root, double target) {
        Node[] ans = new Node[1];
        double[] diff = new double[1];
        diff[0] = Double.MAX_VALUE;
        dfs(root, target, ans, diff);
        return ans[0].val;
    }

    /**
     * DFS traversal through the tree
     *
     * @param x
     * @param target
     * @param ans
     * @param diff
     */
    private static void dfs(Node x, double target, Node[] ans, double[] diff) {
        if (x == null) { return; }
        if (Math.abs(x.val - target) < diff[0]) {
            diff[0] = Math.abs(x.val - target);
            ans[0] = x;
        }
        dfs(x.left, target, ans, diff);
        dfs(x.right, target, ans, diff);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        double target = 3.714286;
        System.out.println(closestValue(root, target));
    }
}
