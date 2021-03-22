import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left
 * to right, level by level from leaf to root).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
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
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class Problem107 {

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
     * Method to traverse the tree and store elements in list
     * DFS
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);
        return res;
    }

    /**
     * DFS
     * Recursive method to traverse the tree, incrementing the level each time it goes further into the children
     *
     * @param x
     * @param res
     * @param level
     */
    private static void traversal(Node x, List<List<Integer>> res, int level) {
        if (x == null) { return; }
        if (res.size() == level) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - level - 1).add(x.val);

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

        System.out.println(levelOrderBottom(root));
    }
}
