import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element
 * of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but
 * not in nums.
 *
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 *
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * Example 3:
 * Input: nums = []
 * Output: []
 *
 * Example 4:
 * Input: nums = [-1]
 * Output: ["-1"]
 *
 * Example 5:
 * Input: nums = [0]
 * Output: ["0"]
 *
 * Constraints:
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 */
public class Problem228 {

    /**
     * Method to get summary ranges. Use stringBuilder to save on time, as converting num to string results in
     * creating new string object
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param nums
     * @return
     */
    private static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) { return result; }

        StringBuilder sb = new StringBuilder();
        int temp = nums[0];
        sb.append(temp);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 < nums[i]) {
                if (temp < nums[i - 1]) {
                    sb.append("->").append(nums[i - 1]);
                }
                result.add(sb.toString());
                sb = new StringBuilder();
                temp = nums[i];
                sb.append(temp);
            }
        }

        if (temp < nums[nums.length - 1]) {
            sb.append("->").append(nums[nums.length - 1]);
        }
        result.add(sb.toString());
        return result;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }
}
