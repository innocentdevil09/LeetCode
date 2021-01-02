import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Problem90 {

    /**
     * Method to return all the possible subsets for the given nums array
     * Approach used: backtracking
     * Time complexity: O(2^n)
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    /**
     * Method to use the backtrack approach in order to get all the possible subsets for the given nums array
     *
     * @param result
     * @param list
     * @param nums
     * @param start
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { continue; }
            list.add(nums[i]);
            backtrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,2,2};

        System.out.println(subsetsWithDup(nums));
    }
}
