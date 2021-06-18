import java.util.Arrays;

/**
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once. You can return the answer in any order.
 *
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 *
 * Example 2:
 * Input: nums = [-1,0]
 * Output: [-1,0]
 *
 * Example 3:
 * Input: nums = [0,1]
 * Output: [1,0]
 *
 * Constraints:
 * 2 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * Each integer in nums will appear twice, only two integers will appear once.
 */
public class Problem260 {

    /**
     * Bit Manipulation
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    private static int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int n : nums) {
            bitmask ^= n;
        }

        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int n : nums) {
            if ((n & diff) != 0) {
                x ^= n;
            }
        }
        return new int[]{x, bitmask^x};
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};

        int[] result = singleNumber(nums);
        Arrays.stream(result).forEach(System.out::println);
    }
}
