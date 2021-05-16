import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, turn the tree upside down and return the new root.
 *
 * You can turn a binary tree upside down with the following steps:
 *
 * The original left child becomes the new root.
 * The original root becomes the new right child.
 * The original right child becomes the new left child.
 *
 * The mentioned steps are done level by level, it is guaranteed that every node in the given tree has either 0 or 2
 * children.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5]
 * Output: [4,5,2,null,null,3,1]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the tree will be in the range [0, 10].
 * 1 <= Node.val <= 10
 * Every node has either 0 or 2 children.
 */
public class Problem156 {

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

    /*
    private static Node upsideDownBinaryTree(Node root) {
        if (root == null) { return null; }
        Deque<Node> stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.left = stack.isEmpty() ? null : stack.peek().right;
            node.right = stack.isEmpty() ? null : stack.peek();
            if (root == null) {
                root = node;
            }
        }
        return root;
    }
     */

    /**
     * Simple approach to upside down binary tree using variables
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param root
     * @return
     */
    private static Node upsideDownBinaryTree(Node root) {
        if (root == null) { return null; }
        Node curr = root;
        Node prev = null, next = null, temp = null;

        while (curr != null) {
            next = curr.left;

            // swapping nodes now, need temp to keep the previous right child
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
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

        root = upsideDownBinaryTree(root);
    }
}
