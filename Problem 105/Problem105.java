import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class Problem105 {

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
     * Method to build tree given array for preorder and inorder traversal
     * <p>
     *     This problem basically examines your understanding of preorder and inorder binary tree traversals. Would
     *     be good to read up on postorder traversal as well.
     * </p>
     *
     * @param preorder
     * @param inorder
     * @return
     */
    private static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        IntStream.range(0, inorder.length).forEach(i -> inorderMap.put(inorder[i], i));

        int[] preorderIndex = new int[1];
        return buildTreeHelper(preorder, preorderIndex, 0, inorder.length - 1, inorderMap);
    }

    /**
     * Helper method to build tree
     * We use the property of inorder traversal, that all elements to the left of root will belong in its left child
     * and the rest in its right child. Therefore, we create a map to keep track on its indices.
     * And use preorderIndex to create subtrees.
     *
     * @param preorder
     * @param preorderIndex
     * @param left
     * @param right
     * @param inorderMap
     * @return
     */
    private static Node buildTreeHelper(int[] preorder, int[] preorderIndex, int left, int right, Map<Integer, Integer> inorderMap) {

        if (left > right) { return null; }
        int rootVal = preorder[preorderIndex[0]++];
        Node root = new Node(rootVal);

        root.left = buildTreeHelper(preorder, preorderIndex, left, inorderMap.get(rootVal) - 1, inorderMap);
        root.right = buildTreeHelper(preorder, preorderIndex, inorderMap.get(rootVal) + 1, right, inorderMap);
        return root;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] preorder = {3, 9, 1, 2, 20, 15, 7};
        int[] inorder = {1, 9, 2, 3, 15, 20, 7};

        Node root = buildTree(preorder, inorder);
    }
}
