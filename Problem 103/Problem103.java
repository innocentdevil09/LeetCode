import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to
 * right, then right to left for the next level and alternate between).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
 */
public class Problem103 {

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
     * Method to return list of elements in zigzag order of level traversal
     *
     * @param root
     * @return
     */
    private static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);
        return res;
    }

    /**
     * DFS approach to traverse a given tree and add elements to list in zigzag fashion, based on its level
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

        if (level % 2 == 0) {
            res.get(level).add(x.val);
        } else {
            res.get(level).add(0, x.val);
        }
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

        System.out.println(zigzagLevelOrder(root));
    }
}
