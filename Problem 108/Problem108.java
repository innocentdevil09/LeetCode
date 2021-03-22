/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced
 * binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs
 * by more than one.
 *
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
public class Problem108 {

    /**
     * Inner Node class for Tree data structure
     */
    private static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }
    }

    /**
     * Method to build a tree for given sorted nums array
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums
     * @return
     */
    private static Node sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    /**
     * Recursive class to build tree. O(log n) for recursive stack
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static Node buildTree(int[] nums, int left, int right) {
        if (left > right) { return null; }

        int mid = left + (right - left) / 2;
        Node root = new Node(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        Node root = sortedArrayToBST(nums);
    }
}
