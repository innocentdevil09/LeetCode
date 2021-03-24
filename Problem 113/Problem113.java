import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum
 * equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 *
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 *
 * Example 3:
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Problem113 {

    /**
     * Inner Node class for Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to return all paths from root to leaf, that equals to pathSum
     * DFS (Backtracking)
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     *
     * @param root
     * @param pathSum
     * @return
     */
    private static List<List<Integer>> pathSum(Node root, int pathSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }
        dfs(res, new ArrayList<>(), root, pathSum);
        return res;
    }

    /**
     * Backtracking method to add values to list, and add to the result if we reach leaf node with sum of all
     * elements equal to pathSum
     *
     * @param res
     * @param list
     * @param x
     * @param target
     */
    private static void dfs(List<List<Integer>> res, List<Integer> list, Node x, int target) {
        if (x == null) { return; }
        list.add(x.val);
        if (x.left == null && x.right == null && target == x.val) {
            res.add(new ArrayList<>(list));
        } else {
            dfs(res, list, x.left, target - x.val);
            dfs(res, list, x.right, target - x.val);
        }
        list.remove(list.size() - 1);
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
        root.right.right.left = new Node(5);

        System.out.println(pathSum(root, 22));
    }
}
