/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
 * and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 *
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class Problem152 {

    /**
     * DP approach to get max product subarray
     * So the problem reduces to getting the highest combo chain
     * The way combo chains work is that they build on top of the previous combo chains that you have acquired.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    private static int maxProduct(int[] nums) {
        if (nums.length == 0) { return 0; }

        int max = nums[0];
        int iMin = nums[0], iMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            iMax = Math.max(nums[i], iMax * nums[i]);
            iMin = Math.min(nums[i], iMin * nums[i]);

            max = Math.max(max, iMax);
        }
        return max;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
