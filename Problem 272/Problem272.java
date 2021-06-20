import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are
 * closest to the target. You may return the answer in any order.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 * Example 1:
 * Input: root = [4,2,5,1,3], target = 3.714286, k = 2
 * Output: [4,3]
 *
 * Example 2:
 * Input: root = [1], target = 0.000000, k = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 10^4.
 * 0 <= Node.val <= 10^9
 * -10^9 <= target <= 10^9
 *
 * Follow up: Assume that the BST is balanced. Could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class Problem272 {

    /**
     * Inner Node class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to fetch k Nodes with values closest to target
     * DFS traversal
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    private static List<Integer> closestKValues(Node root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        process(root, list, target, k);
        return list;
    }

    /**
     * DFS traversal of tree
     *
     * @param x
     * @param list
     * @param target
     * @param k
     */
    private static void process(Node x, List<Integer> list, double target, int k) {
        if (x == null || k == 0) { return; }

        process(x.left, list, target, k);

        if (list.size() == k) {
            if (Math.abs(x.val - target) < Math.abs(list.get(0) - target)) {
                list.remove(0);
                list.add(x.val);
            }
        } else {
            list.add(x.val);
        }

        process(x.right, list, target, k);
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
        int k = 2;
        System.out.println(closestKValues(root, target, k));
    }
}
