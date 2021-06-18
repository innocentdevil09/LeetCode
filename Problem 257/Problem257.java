import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 *
 * Example 2:
 * Input: root = [1]
 * Output: ["1"]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
public class Problem257 {

    /**
     * Inner Node class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to get all the paths from given root of tree
     * DFS approach
     *
     * Time Complexity: O(log N)
     * Space Complexity: O(log N)
     *
     * @param root
     * @return
     */
    private static List<String> binaryTreePaths(Node root) {
        if (root == null) { return new ArrayList<>(); }
        List<String> res = new ArrayList<>();
        dfs(res, root, String.valueOf(root.val));
        return res;
    }

    /**
     * DFS traversal of the tree
     *
     * @param res
     * @param x
     * @param s
     */
    private static void dfs(List<String> res, Node x, String s) {
        if (x.left == null && x.right == null) {
            res.add(s);
        }
        if (x.left != null) {
            dfs(res, x.left, s + "->" + x.left.val);
        }
        if (x.right != null) {
            dfs(res, x.right, s + "->" + x.right.val);
        }
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

        System.out.println(binaryTreePaths(root));
    }
}
