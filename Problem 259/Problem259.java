import java.util.Arrays;

/**
 * Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j
 * < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * Example 1:
 * Input: nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 *
 * Example 2:
 * Input: nums = [], target = 0
 * Output: 0
 *
 * Example 3:
 * Input: nums = [0], target = 0
 * Output: 0
 *
 * Constraints:
 * n == nums.length
 * 0 <= n <= 3500
 * -100 <= nums[i] <= 100
 * -100 <= target <= 100
 */
public class Problem259 {

    /**
     * Method to return counts of three sum smaller than target
     *
     * Time Complexity: O(N logN)
     * Space Complexity: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < len - 2; i++) {
            int j = i + 1, k = len - 1;
            int newTarget = target - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] < newTarget) {
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        int target = 2;
        System.out.println(threeSumSmaller(nums, target));
    }
}
