/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target
 * value.
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 */
public class Problem34 {

    /**
     * The approach involves using binary search to fetch the index of the target element present in the array. The,
     * check the nearby elements to fetch the first & last index to return the answer.
     *
     * Optimisation: Obviously, time complexity of the given solution reaches O(n) in case if the array contains all
     * the same elements as the target. Fetching the first and last index by checking nearby elements would result in
     * O(n) time complexity. To avoid, we need to modify the method for binary search.
     * We need to write two methods for modified binary search to return the extreme left or right indices of the
     * target element in the given array.
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }

        int lastIndex = index;
        while (lastIndex < nums.length - 1 && nums[lastIndex + 1] == target) {
            lastIndex++;
        }
        int firstIndex = index;
        while (firstIndex > 0 && nums[firstIndex - 1] == target) {
            firstIndex--;
        }
        return new int[]{firstIndex, lastIndex};
    }

    /**
     * Method for binary search
     *
     * @param nums
     * @param target
     * @return
     */
    private static int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;

        int[] range = searchRange(nums, target);
        System.out.println("{" + range[0] + ", " + range[1] + "}");
    }
}
