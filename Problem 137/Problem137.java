/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 *
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 *
 * Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Problem137 {

    /**
     * The idea is to:
     * 1. change seen_once only if seen_twice is unchanged
     * 2. change seen_twice only if seen_once is unchanged
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        int seen_once = 0, seen_twice = 0;
        for (int n : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seen_once = ~seen_twice & (seen_once ^ n);
            seen_twice = ~seen_once & (seen_twice ^ n);
        }

        return seen_once;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber(nums));
    }
}
