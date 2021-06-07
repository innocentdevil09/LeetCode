import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
 * you can see ordered from top to bottom.
 *
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 *
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class Problem199 {

    /**
     * Inner Node class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to return right side view of tree.
     * DFS approach
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root
     * @return
     */
    private static List<Integer> rightSideView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) { return res; }
        dfs(root, res, 0);
        return res;
    }

    /**
     * DFS method to traverse given tree
     *
     * @param x
     * @param res
     * @param level
     */
    private static void dfs(Node x, List<Integer> res, int level) {
        if (x == null) { return; }
        if (res.size() == level) {
            res.add(x.val);
        }
        dfs(x.right, res, level + 1);
        dfs(x.left, res, level + 1);
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
        root.left.right = new Node(5);
        root.right.right = new Node(4);

        System.out.println(rightSideView(root));
    }
}
