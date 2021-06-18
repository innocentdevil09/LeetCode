import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of unique integers preorder, return true if it is the correct preorder traversal sequence of a
 * binary search tree.
 *
 * Example 1:
 *
 * Input: preorder = [5,2,1,3,6]
 * Output: true
 *
 * Example 2:
 * Input: preorder = [5,2,6,1,3]
 * Output: false
 *
 * Constraints:
 * 1 <= preorder.length <= 10^4
 * 1 <= preorder[i] <= 10^4
 * All the elements of preorder are unique.
 *
 * Follow up: Could you do it using only constant space complexity?
 */
public class Problem255 {

    /**
     * Method to determine the given array is a verified binary tree
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param preorder
     * @return
     */
    private static boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int min = Integer.MIN_VALUE;

        for (int num : preorder) {
            if (num < min) { return false; }
            if (!stack.isEmpty() && stack.peek() < num) {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] preorder = {5,2,1,3,6};
        System.out.println(verifyPreorder(preorder));
    }
}
