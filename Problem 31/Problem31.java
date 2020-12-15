/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in
 * ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 *
 * Example 3:
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 *
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class Problem31 {

    /**
     * Method to compute the lexicographic next permutation in the series for the given array
     *
     * @param nums
     */
    private static void nextPermutation(int[] nums) {
        int size = nums.length, i = 0;
        for (i = size - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            reverse(nums, 0, size - 1);
            return;
        }
        int ceiling = findCeiling(nums, nums[i], i + 1, size - 1);
        swap(nums, i, ceiling);
        reverse(nums, i + 1, size - 1);
    }

    /**
     * Method to reverse a given array between the given two indexes
     *
     * @param nums
     * @param lo
     * @param hi
     */
    private static void reverse(int[] nums, int lo, int hi) {
        while (lo < hi && nums[lo] > nums[hi]) {
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }

    /**
     * Method to swap two elements in the array
     *
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    /**
     * Method to find the index of the next element in the array to get lexicographic next permutation in the series
     *
     * @param nums
     * @param threshold
     * @param start
     * @param end
     * @return
     */
    private static int findCeiling(int[] nums, int threshold, int start, int end) {
        int ceiling = end;
        while (ceiling >= start && nums[ceiling] <= threshold) {
            ceiling--;
        }
        return ceiling;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);

        for (int n : nums) {
            System.out.print(n + ", ");
        }
    }
}
