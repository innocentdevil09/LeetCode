import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 *
 * Example 2:
 * Input: root = [1]
 * Output: 0
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 */
public class Problem404 {

    /**
     * Inner class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to determine sum of only left leaf node values
     * Iterative approach.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root
     * @return
     */
    private static int sumOfLeftLeaves(Node root) {
        if (root == null || (root.left == null && root.right == null)) { return 0; }

        Deque<Node> stack = new ArrayDeque<>();
        int sum = 0;

        Node temp = root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root != temp && root.left == null && root.right == null) {
                sum += root.val;
            }
            root = root.right;
            temp = root;
        }
        return sum;
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

        System.out.println(sumOfLeftLeaves(root));
    }
}
