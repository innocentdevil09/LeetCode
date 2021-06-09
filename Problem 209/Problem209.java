/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
 * subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no
 * such subarray, return 0 instead.
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 * Constraints:
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is
 * O(n log(n)).
 */
public class Problem209 {

    /**
     * Method to return len of sub-array whose sum of elements equals target
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * @param target
     * @param nums
     * @return
     */
    private static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0;

        int len = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
