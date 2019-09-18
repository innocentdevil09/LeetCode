import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Problem15 {

    /**
     * Method to get unique sets of numbers a, b, c such that a + b + c = 0
     * Time complexity : O(n^2)
     * Space Complexity : O(1)
     *
     * @param nums
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { continue; } // skip duplicates
            int x = nums[i];
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int sum = x + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(x, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) { l++; } // skip duplicates
                    while (l < r && nums[r] == nums[r - 1]) { r--; } // skip duplicates
                    l++;
                    r--;
                } else if (sum < 0) {
                    while (l < r && nums[l] == nums[l + 1]) { l++; } // skip duplicates
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) { r--; } // skip duplicates
                    r--;
                }
            }
        }
        return result;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(nums));
    }
}
