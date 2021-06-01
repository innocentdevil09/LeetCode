/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
 * always exists in the array.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class Problem169 {

    /**
     * Boyer-Moore Voting Algorithm
     *
     * Essentially, what Boyer-Moore does is look for a suffix suf of nums where suf[0] is the majority element in that
     * suffix. To do this, we maintain a count, which is incremented whenever we see an instance of our current
     * candidate for majority element and decremented whenever we see anything else. Whenever count equals 0, we
     * effectively forget about everything in nums up to the current index and consider the current number as the
     * candidate for majority element.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    private static int majorityElement(int[] nums) {
        if (nums.length == 0) { return -1; }
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
