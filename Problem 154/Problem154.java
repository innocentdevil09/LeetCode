/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array
 * nums = [0,1,4,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1],
 * a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 *
 * Example 1:
 * Input: nums = [1,3,5]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [2,2,2,0,1]
 * Output: 0
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums is sorted and rotated between 1 and n times.
 *
 * Follow up: This is the same as Find Minimum in Rotated Sorted Array but with duplicates. Would allow duplicates
 * affect the run-time complexity? How and why?
 */
public class Problem154 {

    /**
     * Binary search approach to find the minimum element containing duplicates
     *
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    private static int findMin(int[] nums) {
        if (nums.length == 0) { return -1; }
        if (nums.length == 1) { return nums[0]; }

        int n = nums.length;
        if (nums[0] < nums[n - 1]) { return nums[0]; }

        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            while (lo < hi && nums[lo] == nums[lo + 1]) { lo++; }
            while (hi > lo && nums[hi] == nums[hi - 1]) { hi--; }

            int mid = lo + (hi - lo) / 2;
            if (mid < n - 1 && nums[mid] > nums[mid + 1]) { return nums[mid + 1]; }
            if (mid > 0 && nums[mid] < nums[mid - 1]) { return nums[mid]; }

            if (nums[0] < nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return nums[hi];
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        System.out.println(findMin(nums));
    }
}
