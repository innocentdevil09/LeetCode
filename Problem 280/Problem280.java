import java.util.Arrays;

/**
 * Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * You may assume the input array always has a valid answer.
 *
 * Example 1:
 * Input: nums = [3,5,2,1,6,4]
 * Output: [3,5,1,6,2,4]
 * Explanation: [1,6,2,5,3,4] is also accepted.
 *
 * Example 2:
 * Input: nums = [6,6,5,6,3,8]
 * Output: [6,6,5,6,3,8]
 *
 * Constraints:
 * 1 <= nums.length <= 5 * 10^4
 * 0 <= nums[i] <= 10^4
 * It is guaranteed that there will be an answer for the given input nums.
 *
 * Follow up: Could you do it without sorting the array?
 */
public class Problem280 {

    /**
     * Method to wiggle sort the array
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param nums
     */
    private static void wiggleSort(int[] nums) {
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            less = !less;
        }
    }

    /**
     * Method to swap numbers in array
     *
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3,5,2,1,6,4};
        wiggleSort(nums);
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
    }
}
