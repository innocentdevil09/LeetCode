import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * Follow up: Could you implement the O(n) solution?
 */
public class Problem128 {

    /**
     * Method to find longest streak of consecutive integers
     * Uses a set to determine if currentNum + 1 is present to determine if we could continue the streak
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums
     * @return
     */
    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);

        int ans = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int currentNum = n;
                int tempMax = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    tempMax++;
                }
                ans = Math.max(ans, tempMax);
            }
        }
        return ans;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }
}
