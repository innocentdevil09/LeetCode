/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the
 * order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * Constraints:
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class Problem300 {

    /**
     * Method to fetch longest consecutive increasing subsequence of array
     *
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N)
     *
     * @param nums
     * @return
     */
    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) { return 0; }
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        int idx = 1;
        for (int i = 1; i < n; i++) {
            if (dp[0] > nums[i]) {
                dp[0] = nums[i];
            } else if (dp[idx - 1] < nums[i]) {
                dp[idx] = nums[i];
                idx += 1;
            } else {
                int key = getCeil(dp, idx, nums[i]);
                dp[key] = nums[i];
            }
        }
        return idx;
    }

    /**
     * Given val and threshold index, fetch the index where val would fit in the array
     *
     * @param dp
     * @param thresholdIndex
     * @param val
     * @return
     */
    private static int getCeil(int[] dp, int thresholdIndex, int val) {
        int i = 0;
        while (i < thresholdIndex) {
            if (dp[i] > val) {
                break;
            }
            i++;
        }
        return i;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
