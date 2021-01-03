/**
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 * The cloned tree is a copy of the original tree.
 * Return a reference to the same node in the cloned tree.
 *
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference
 * to a node in the cloned tree.
 *
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 *
 * Example 1:
 * Input: tree = [7,4,3,null,null,6,19], target = 3
 * Output: 3
 * Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the
 * original tree. The answer is the yellow node from the cloned tree.
 *
 * Example 2:
 * Input: tree = [7], target =  7
 * Output: 7
 *
 * Example 3:
 * Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 * Output: 4
 *
 * Example 4:
 * Input: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
 * Output: 5
 *
 * Example 5:
 * Input: tree = [1,2,null,3], target = 2
 * Output: 2
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * The values of the nodes of the tree are unique.
 * target node is a node from the original tree and is not null.
 */
public class Problem1379 {

    /**
     * Inner Node data structure used to represent tree
     */
    private static class Node {
        Node left, right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to return reference to the target node in the cloned tree
     *
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    private static Node getTargetCopy(final Node original, final Node cloned, final Node target) {

        return getTargetCopyHelper(original, cloned, target);
    }

    /**
     * Helper method to return the matched node with the same val as target, alongwith its subtree
     *
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    private static Node getTargetCopyHelper(Node original, Node cloned, Node target) {
        if (original == null || cloned == null) { return null; }
        if (cloned.val == target.val && isSubTreeMatch(target, cloned)) {
            return cloned;
        }

        Node node = getTargetCopyHelper(original.left, cloned.left, target);
        if (node != null) { return node; }
        return getTargetCopyHelper(original.right, cloned.right, target);
    }

    /**
     * Method to check if node and its left and right subtree matches with that of the given target node
     *
     * @param target
     * @param cloned
     * @return
     */
    private static boolean isSubTreeMatch(Node target, Node cloned) {
        if (target != null && cloned == null) { return false; }
        if (target == null && cloned != null) { return false; }
        if (target == null && cloned == null) { return true; }

        return (target.val == cloned.val)
                && isSubTreeMatch(target.left, cloned.left)
                && isSubTreeMatch(target.right, cloned.right);
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        Node original = new Node(1);
        original.left = new Node(3);
        original.right = new Node(2);
        original.left.left = new Node(6);
        original.left.right = new Node(7);
        original.right.left = new Node(4);
        original.right.right = new Node(5);
        original.right.right.left = new Node(10);
        original.right.left.left = new Node(8);
        original.right.left.right = new Node(9);

        Node cloned = new Node(1);
        cloned.left = new Node(3);
        cloned.right = new Node(2);
        cloned.left.left = new Node(6);
        cloned.left.right = new Node(7);
        cloned.right.left = new Node(4);
        cloned.right.right = new Node(5);
        cloned.right.right.left = new Node(10);
        cloned.right.left.left = new Node(8);
        cloned.right.left.right = new Node(9);

        Node target = new Node(5);
        target.left = new Node(10);

        Node result = getTargetCopy(original, cloned, target);
        System.out.println(result.val);
    }
}
