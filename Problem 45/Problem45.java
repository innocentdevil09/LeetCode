/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps
 * to the last index.
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class Problem45 {

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
    private static int jump(int[] nums) {
        int jump = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                currentEnd = farthest;
                jump++;
            }
        }
        return jump;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 1};

        System.out.println(jump(nums));
    }
}
