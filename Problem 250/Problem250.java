import java.util.HashSet;
import java.util.Set;

/**
 * Given the root of a binary tree, return the number of uni-value subtrees.
 * A uni-value subtree means all nodes of the subtree have the same value.
 *
 * Example 1:
 * Input: root = [5,1,5,5,5,null,5]
 * Output: 4
 *
 * Example 2:
 * Input: root = []
 * Output: 0
 *
 * Example 3:
 * Input: root = [5,5,5,5,5,null,5]
 * Output: 6
 *
 * Constraints:
 * The numbrt of the node in the tree will be in the range [0, 1000].
 * -1000 <= Node.val <= 1000
 */
public class Problem250 {

    /**
     * Inner Node class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * DFS approach.
     * Method to count number of unival nodes
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root
     * @return
     */
    private static int countUnivalSubtrees(Node root) {
        Set<Node> set = new HashSet<>();
        isUnivalNode(root, set);
        return set.size();
    }

    /**
     * DFS method for tree traversal
     *
     * @param x
     * @param set
     * @return
     */
    private static boolean isUnivalNode(Node x, Set<Node> set) {
        if (x == null) { return true; }
        boolean left = isUnivalNode(x.left, set);
        boolean right = isUnivalNode(x.right, set);

        if (left && right) {
            boolean leftSubTree = x.left == null || x.left.val == x.val;
            boolean rightSubTree = x.right == null || x.right.val == x.val;
            if (leftSubTree && rightSubTree) {
                set.add(x);
                return true;
            }
        }
        return false;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(5);
        root.left.left = new Node(5);
        root.left.right = new Node(5);
        root.right.right = new Node(5);

        System.out.println(countUnivalSubtrees(root));
    }
}
