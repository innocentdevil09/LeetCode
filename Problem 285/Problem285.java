/**
 * Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST.
 * If the given node has no in-order successor in the tree, return null.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 * Example 1:
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the answer is null.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^5 <= Node.val <= 10^5
 * All Nodes will have unique values.
 */
public class Problem285 {

    /**
     * Inner Node class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to fetch next in-line successor for given Node p -- while traversing inorder
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param root
     * @param p
     * @return
     */
    private static Node inorderSuccessor(Node root, Node p) {
        Node result = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                result = root;
                root = root.left;
            }
        }
        return result;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);

        Node successor = inorderSuccessor(root, new Node(6));
        System.out.println(successor == null ? "NULL" : successor.val);
    }
}
