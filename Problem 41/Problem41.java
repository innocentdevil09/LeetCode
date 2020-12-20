/**
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 *
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
 *
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 * Constraints:
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 */
public class Problem41 {

    /**
     * The basic idea is that we have an array with n cells (n is the length of the array). If an integer is missing it
     * must be in the range [1..n]. This is the crucial observation we use to deduce the algorithm. This means that the
     * range of possible answers is [1..n] if an integer is missing, and if an integer is not missing then the answer is
     * n+1.
     *
     * There are only two possibilities:
     * 1. there is no missing integer in the array
     * 2. there is a missing integer in the array.
     *
     * @param nums
     * @return
     */
    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        System.out.println(firstMissingPositive(nums));
    }
}
