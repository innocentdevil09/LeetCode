/**
 * You are given an integer array nums sorted in ascending order, and an integer target.
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become
 * [4,5,6,7,0,1,2]).
 * If target is found in the array return its index, otherwise, return -1.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is guranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 */
public class Problem33 {

    /**
     * The approach is to use the rotated sort property of the array.
     * Each element in the first half of the array until the pivot, is in ascending order. Whereas the element from
     * the right side of the array is in descending order until the pivot index.
     * Hence, using this property we can easily determine the part of the array containing the element.
     *
     * Worst case scenario would be O(n - 1) ~ O(n)
     * However, the time complexity would remain the same in case we try to find the pivot index and later use binary
     * search to get the element.
     *
     * @param nums
     * @param target
     * @return
     */
    private static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        for (int j = nums.length - 1; j >= 0 && nums[j] >= target; j--) {
            if (nums[j] == target) {
                return j;
            }
        }
        return -1;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums, target));
    }
}
