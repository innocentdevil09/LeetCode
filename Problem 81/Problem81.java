/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class Problem81 {

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
    private static boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        for (int j = nums.length - 1; j >= 0 && nums[j] >= target; j--) {
            if (nums[j] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;

        System.out.println(search(nums, target));
    }
}
