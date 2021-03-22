import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
 * postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class Problem106 {

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
     * Method to build a tree given inorder and postorder binary tree traversals
     * While inorder reads Left -> Root -> Right,
     * postorder reads Left -> Right -> Root
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param inorder
     * @param postorder
     * @return
     */
    private static Node buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        IntStream.range(0, inorder.length).forEach(i -> inorderMap.put(inorder[i], i));
        int[] postOrderIndex = new int[1];
        postOrderIndex[0] = postorder.length - 1;
        return buildTreeHelper(postorder, postOrderIndex, inorderMap, 0, inorder.length - 1);
    }

    /**
     * Recursive method to create subtrees from postorder tree traversal
     * We use the property of inorder traversal, that all elements to the left of root will belong in its left child
     * and the rest in its right child. Therefore, we create a map to keep track on its indices.
     * And use preorderIndex to create subtrees.
     *
     * @param postorder
     * @param postOrderIndex
     * @param inorderMap
     * @param left
     * @param right
     * @return
     */
    private static Node buildTreeHelper(int[] postorder, int[] postOrderIndex, Map<Integer, Integer> inorderMap,
            int left, int right) {

        if (left > right) { return null; }
        int rootVal = postorder[postOrderIndex[0]--];
        Node root = new Node(rootVal);

        root.right = buildTreeHelper(postorder, postOrderIndex, inorderMap, inorderMap.get(rootVal) + 1, right);
        root.left = buildTreeHelper(postorder, postOrderIndex, inorderMap, left, inorderMap.get(rootVal) - 1);
        return root;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postoder = {9, 15, 7, 20, 3};

        Node root = buildTree(inorder, postoder);
    }
}
