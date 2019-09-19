import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
 * to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Problem16 {

    /**
     * Method to get the sum of three numbers a, b, c in the array which is closest to the given target
     *
     * @param nums
     * @param target
     */
    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE, result = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int x = nums[i];
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int dist = dist(x + nums[l] + nums[r], target);
                if (dist == 0) { return target; }

                if (dist < closest) {
                    closest = dist;
                    result = x + nums[l] + nums[r];
                }
                if (dist(x + nums[l + 1] + nums[r], target) < dist(x + nums[l] + nums[r - 1], target)) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    /**
     * Method to get the distance between two numbers on the number line system
     *
     * @param num1
     * @param num2
     */
    private static int dist(int num1, int num2) {
        if (num1 > num2) {
            return num1 - num2;
        }
        return num2 - num1;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(threeSumClosest(nums, target));
    }
}
