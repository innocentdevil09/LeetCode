import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 */
public class Problem101 {

    /**
     * Inner Node data structure for Trees
     */
    private static class Node {
        Node left, right;
        int val;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to check symmetric for tree iteratively
     *
     * @param root
     * @return
     */
    private static boolean isSymmetric(Node root) {
        if (root == null) { return true; }
        Queue<Node> p = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();

        if (root.left != null) { p.add(root.left); }
        if (root.right != null) { q.add(root.right); }

        while (!p.isEmpty() && !q.isEmpty()) {
            Node pNode = p.poll();
            Node qNode = q.poll();
            if (pNode == null && qNode == null) { continue; }
            if (pNode == null || qNode == null) { return false; }

            if (pNode.val != qNode.val) { return false; }
            p.add(pNode.left);
            q.add(qNode.right);
            p.add(pNode.right);
            q.add(qNode.left);
        }
        return p.isEmpty() && q.isEmpty();
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.right = new Node(3);
        root.right.right = new Node(3);

        System.out.println(isSymmetric(root));
    }
}
