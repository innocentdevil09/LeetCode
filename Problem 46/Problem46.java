import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any
 * order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Problem46 {

    /**
     * Method to get all the possible permutation for a given array
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        while(isNextPermutation(nums)) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        return result;
    }

    /**
     * Method to check if next permutation is possible, and rearrange the given array to get it
     *
     * @param nums
     * @return
     */
    private static boolean isNextPermutation(int[] nums) {
        int i = 0;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i < 0) { return false; }
        int ceiling = findCeiling(nums, nums[i], i);
        swap(nums, i, ceiling);
        reverse(nums, i + 1, nums.length - 1);
        return true;
    }

    /**
     * Method to find next index to swap with current element to get next permutation
     *
     * @param nums
     * @param threshold
     * @param start
     * @return
     */
    private static int findCeiling(int[] nums, int threshold, int start) {
        int ceiling = nums.length - 1;
        while (ceiling > start && nums[ceiling] <= threshold) {
            ceiling--;
        }
        return ceiling;
    }

    /**
     * Method to reverse array between given indices
     *
     * @param nums
     * @param lo
     * @param hi
     */
    private static void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }

    /**
     * Method to swap two integers
     *
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    /**
     * Method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,1,2};

        System.out.println(permute(nums));
    }
}
