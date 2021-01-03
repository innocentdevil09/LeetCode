import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
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
 * Output: [1,2]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class Problem94 {

    /**
     * Inner Node data structure for Tree
     */
    private static class Node {
        Node left, right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * The important thing to remember about tree is that it is a watered down version of Graph data structure.
     * Therefore, both dfs and bfs traversal are important while solving tree problems.
     *
     * Below is iterative approach for tree traversal
     *
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(3);

        System.out.println(inorderTraversal(root));
    }
}
