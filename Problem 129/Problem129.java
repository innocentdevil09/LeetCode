/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers.
 *
 * A leaf node is a node with no children.
 *
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 */
public class Problem129 {

    /**
     * Inner Node class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to return sum of all root-to-leaf numbers
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root
     * @return
     */
    private static int sumNumbers(Node root) {
        return sum(root, 0);
    }

    /**
     * Recursive method to maintain the state at each node of the root-to-node number
     * Recursive call to return its sum
     *
     * @param x
     * @param s
     * @return
     */
    private static int sum(Node x, int s) {
        if (x == null) { return 0; }
        if (x.left == null && x.right == null) {
            return s * 10 + x.val;
        }
        return sum(x.left, s * 10 + x.val) + sum(x.right, s * 10 + x.val);
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

        System.out.println(sumNumbers(root));
    }
}
