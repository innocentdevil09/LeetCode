/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and
 * all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last
 * level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 *
 * Example 2:
 * Input: root = []
 * Output: 0
 *
 * Example 3:
 * Input: root = [1]
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5 * 104].
 * 0 <= Node.val <= 5 * 10^4
 * The tree is guaranteed to be complete.
 */
public class Problem222 {

    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Binary Search
     * Total no. of nodes till level (d - 1): 2^d - 1
     *
     * Then binary search to get no. of nodes in the last level
     *
     * Time Complexity: O((log N) ^ 2)
     * Space Complexity: O(1)
     *
     * @param root
     * @return
     */
    private static int countNodes(Node root) {
        if (root == null) { return 0; }
        int depth = getDepth(root);
        if (depth == 0) { return 1; }

        int left = 1, right = (int) Math.pow(2, depth) - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (exists(pivot, depth, root)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return (int) Math.pow(2, depth) - 1 + left;
    }

    /**
     * For the last level, the no. of nodes will be between 0 & 2^depth
     * We use binary search to get the number of nodes present in the last level
     *
     * @param pivot
     * @param depth
     * @param x
     * @return
     */
    private static boolean exists(int pivot, int depth, Node x) {
        int left = 0, right = (int) Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; i++) {
            int idx = left + (right - left) / 2;
            if (pivot > idx) {
                x = x.right;
                left = idx + 1;
            } else {
                x = x.left;
                right = idx;
            }
        }
        return x != null;
    }

    /**
     * Method to get depth of node
     *
     * @param root
     * @return
     */
    private static int getDepth(Node root) {
        int depth = 0;
        for (Node x = root; x.left != null; x = x.left) {
            depth++;
        }
        return depth;
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
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println(countNodes(root));
    }
}
