import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
 * level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class Problem102 {

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
     * Method to traverse a given tree based on level horizontally, starting from root
     *
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }
        traversal(root, res, 0);
        return res;
    }

    /**
     * DFS approach to traverse the tree tracking the level of traversal as it goes down along the nodes
     *
     * @param x
     * @param res
     * @param level
     */
    private static void traversal(Node x, List<List<Integer>> res, int level) {
        if (x == null) { return; }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(x.val);
        traversal(x.left, res, level + 1);
        traversal(x.right, res, level + 1);
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

        System.out.println(levelOrder(root));
    }
}
