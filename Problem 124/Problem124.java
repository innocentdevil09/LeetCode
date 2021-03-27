/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
 * connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass
 * through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 * Example 2:
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 */
public class Problem124 {

    /**
     * Inner Node class for Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to get maximum path sum. The problem statement does not mandate root node to be a part of the path.
     * Hence, we define a variable, and traverse the tree calculating the max_gain for each node -- updating the
     * variable at the same time.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(log n)
     *
     * @param root
     * @return
     */
    private static int maxPathSum(Node root) {
        int[] max_sum = new int[1];
        max_sum[0] = Integer.MIN_VALUE;
        max_gain(root, max_sum);
        return max_sum[0];
    }

    /**
     * Recursive method to track gain for each node from its children
     *
     * @param x
     * @param max_sum
     * @return
     */
    private static int max_gain(Node x, int[] max_sum) {
        if (x == null) { return 0; }
        int left_gain = Math.max(max_gain(x.left, max_sum), 0);
        int right_gain = Math.max(max_gain(x.right, max_sum), 0);

        int price_newpath = x.val + left_gain + right_gain;
        max_sum[0] = Math.max(max_sum[0], price_newpath);

        return x.val + Math.max(left_gain, right_gain);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(maxPathSum(root));
    }
}
