import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 * Example 4:
 * Input: root = [1,2]
 * Output: [2,1]
 *
 * Example 5:
 * Input: root = [1,null,2]
 * Output: [2,1]
 *
 * Constraints:
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Follow up:
 * Recursive solution is trivial, could you do it iteratively?
 */
public class Problem145 {

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
     * Iterative traversal
     *
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) { return list; }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(0, root.val);
            if (root.left != null) { stack.push(root.left); }
            if (root.right != null) { stack.push(root.right); }
        }
        return list;
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
        root.right.left = new Node(4);

        System.out.println(postorderTraversal(root));
    }
}
