/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it
 * impossible to reach the last index.
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 */
public class Problem55 {

    /**
     * Implicitly the approach to solve this problem is via bfs.
     * We need to add all the nodes we can reach out to, to the queue -- and increment jump counter accordingly.
     * Alternatively, since we know the maximum jump we can take at index 0, let's say it is 3, that would be our
     * jump = 1 and we can reach out farthest to in the array depending upon the values present in index 1, 2, & 3,
     * for our jump 2.
     * Taking benefit of this hindsight, we can increment our jump counter accordingly.
     *
     * @param nums
     * @return
     */
    private static boolean canJump(int[] nums) {
        int currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == currentEnd) {
                currentEnd = farthest;
            }
        }
        return currentEnd >= nums.length - 1;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};

        System.out.println(canJump(nums));
    }
}
