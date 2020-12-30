import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class Problem78 {

    /**
     * Method to get all the possible subsets for a given array of nums
     * Time complexity: O(n * 2^n)
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtrack(result, nums, 0);
        return result;
    }

    /**
     * Method for backtracking and adding the element at given index to all the lists contained in the result, to get
     * the next subsets in line
     *
     * @param result
     * @param nums
     * @param index
     */
    private static void backtrack(List<List<Integer>> result, int[] nums, int index) {
        if (index >= nums.length) { return; }
        int n = nums[index];
        List<List<Integer>> tempResult = new ArrayList<>();
        for (List<Integer> list : result) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(n);
            tempResult.add(newList);
        }
        result.addAll(tempResult);
        backtrack(result, nums, index + 1);
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(subsets(nums));
    }
}
