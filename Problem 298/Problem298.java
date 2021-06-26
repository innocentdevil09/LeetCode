/**
 * Given the root of a binary tree, return the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
 * connections. The longest consecutive path needs to be from parent to child (cannot be the reverse).
 *
 * Example 1:
 * Input: root = [1,null,3,2,4,null,null,null,5]
 * Output: 3
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 *
 * Example 2:
 * Input: root = [2,null,3,2,null,1]
 * Output: 2
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 3 * 10^4].
 * -3 * 10^4 <= Node.val <= 3 * 10^4
 */
public class Problem298 {

    /**
     * Inner Node class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to return longest consecutive path with incremental value
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root
     * @return
     */
    private static int longestConsecutive(Node root) {
        if (root == null) { return 0; }
        int[] max = new int[1];
        dfs(root, root, max, 0);
        return max[0];
    }

    /**
     * DFS traversal of tree
     *
     * @param curr
     * @param parent
     * @param max
     * @param count
     */
    private static void dfs(Node curr, Node parent, int[] max, int count) {
        if (curr == null) { return; }
        if (curr.val == parent.val + 1) {
            count += 1;
        } else {
            count = 1;
        }
        max[0] = Math.max(max[0], count);
        dfs(curr.left, curr, max, count);
        dfs(curr.right, curr, max, count);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        root.right.right.right = new Node(5);

        System.out.println(longestConsecutive(root));
    }
}
