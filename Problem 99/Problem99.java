import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 * Example 1:
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 *
 * Example 2:
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 1000].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class Problem99 {

    /**
     * Inner Node data structure for Trees
     */
    private static class Node {
        Node left, right;
        int val;

        Node(int val) { this.val = val; }
    }

    /**
     * Simple and elegant approach.
     * Check if the tree is valid. If not, swap only the values since it's tough to change the children of node too
     *
     * @param root
     */
    private static void recoverTree(Node root) {
        Node node = root;
        while (!isValidBST(node)) { }
    }

    /**
     * Method to swap values of the given nodes
     *
     * @param node
     * @param prev
     */
    private static void swap(Node node, Node prev) {
        int temp = node.val;
        node.val = prev.val;
        prev.val = temp;
    }

    /**
     * Method to check if the given tree is valid. If not, swap the values of nodes
     *
     * @param root
     * @return
     */
    private static boolean isValidBST(Node root) {
        if (root == null) { return true; }
        Deque<Node> stack = new ArrayDeque<>();
        Node prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev.val) {
                swap(root, prev);
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.right = new Node(2);

        recoverTree(root);
        System.out.println(preOrderTraversal(root));
    }

    /**
     * Iterative preorder traversal of tree
     *
     * @param root
     * @return
     */
    private static List<Integer> preOrderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) { return res; }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if (node.right != null) { stack.push(node.right); }
            if (node.left != null) { stack.push(node.left); }
        }
        return res;
    }
}
