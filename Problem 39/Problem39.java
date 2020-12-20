import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for
 * the given input.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Example 4:
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 *
 * Example 5:
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 *
 *
 * Constraints:
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 */
public class Problem39 {

    /**
     * Backtracking algorithms seems like a new concept, however it is exactly same as dfs traversal if you were to
     * create all edges with the possible scenarios.
     * Backtracking algorithms helps in saving space complexity, however time complexity remains same.
     *
     * The algorithm includes, adding each element, one-by-one while at the same time taking care of the target.
     * It is recursive, hence time complexity involved is high.
     *
     * Time Complexity: O(2^n)
     *
     * @param candidates
     * @param target
     * @return
     */
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    /**
     * Method to implement backtracking algorithm, to update the list whenever the sum of all the elements in the
     * list equals target.
     *
     * @param list
     * @param tempList
     * @param candidates
     * @param remain
     * @param start
     */
    private static void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain,
            int start) {
        if (remain < 0) { return; }
        else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtracking(list, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(combinationSum(candidates, target));
    }
}
