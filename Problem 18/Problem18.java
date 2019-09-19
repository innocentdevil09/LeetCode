import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b
 * + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Problem18 {

    /**
     * Method to return unique quadruplets of integers whose sum equals that of the target
     * Time Complexity : O(n^3)
     *
     * Algo: Extending ThreeSum logic to solve FourSum problem
     *
     * @param nums
     * @param target
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { continue; } // skip duplicates

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { continue; } // skip duplicates

                /* These lines optimise the solution to bring time from 31 ms to 5 ms */
                int targetTwoSum = target - nums[i] - nums[j];
                int minTwoSum = nums[j + 1] + nums[j + 2];
                int maxTwoSum = nums[nums.length - 1] + nums[nums.length - 2];
                if (targetTwoSum < minTwoSum || targetTwoSum > maxTwoSum) { continue; }

                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) { l++; } // skip duplicates
                        while (l < r && nums[r] == nums[r -1]) { r--; } // skip duplicates
                        l++;
                        r--;
                    } else if (sum < target) {
                        while (l < r && nums[l] == nums[l + 1]) { l++; } // skip duplicates
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) { r--; } // skip duplicates
                        r--;
                    }
                }
            }
        }
        return quadruplets;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println(fourSum(nums, target));
    }
}
