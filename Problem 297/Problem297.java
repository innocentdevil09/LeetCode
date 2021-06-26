/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not
 * necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Example 1:
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
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
 * Output: [1,2]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * -1000 <= Node.val <= 1000
 */
public class Problem297 {

    /**
     * Inner Node class to represent Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Codec class to serialize and deserialize Tree
     */
    private static class Codec {

        /**
         * Encodes a tree to a single string.
         *
         * @param root
         * @return
         */
        public String serialize(Node root) {
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return sb.toString();
        }

        private void dfs(Node x, StringBuilder sb) {
            if (x == null) {
                sb.append("null|");
                return;
            }
            sb.append(x.val).append("|");
            dfs(x.left, sb);
            dfs(x.right, sb);
        }

        // 1|2|null|null|3|4|null|null|5|null|null|

        /**
         * Decodes your encoded data to tree.
         *
         * @param data
         * @return
         */
        public Node deserialize(String data) {
            String[] vals = data.split("\\|");
            return tree(vals, new int[1]);
        }

        private Node tree(String[] vals, int[] idx) {
            if (idx[0] > vals.length) { return null; }

            String val = vals[idx[0]++];
            if (val.isEmpty() || val.equals("null")) {
                return null;
            }
            Node node = new Node(Integer.parseInt(val));
            node.left = tree(vals, idx);
            node.right = tree(vals, idx);
            return node;
        }
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
        root.right.right = new Node(5);

        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println(data);
        Node x = codec.deserialize(data);
        System.out.println(isSame(x, root));
    }

    /**
     * Method to verify if given tree are same
     *
     * @param x
     * @param root
     * @return
     */
    private static boolean isSame(Node x, Node root) {
        if (x == null && root == null) {
            return true;
        }
        if (x == null || root == null) {
            return false;
        }
        return x.val == root.val && isSame(x.left, root.left) && isSame(x.right, root.right);
    }
}
