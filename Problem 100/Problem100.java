/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in both trees is in the range [0, 100].
 * -10^4 <= Node.val <= 10^4
 */
public class Problem100 {

    /**
     * Inner Node data structure for Trees
     */
    private static class Node {
        Node left, right;
        int val;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to determine if all the node in trees p & q have same values
     *
     * @param p
     * @param q
     * @return
     */
    private static boolean isSameTree(Node p, Node q) {
        if (p == null && q != null) { return false; }
        if (p != null && q == null) { return false; }
        if (p == null && q == null) { return true; }

        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        Node p = new Node(2);
        p.left = new Node(1);
        p.right = new Node(3);

        Node q = new Node(2);
        q.left = new Node(1);
        q.right = new Node(3);

        System.out.println(isSameTree(p, q));
    }
}
