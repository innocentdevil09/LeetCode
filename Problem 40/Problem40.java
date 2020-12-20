import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * Constraints:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class Problem40 {

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
                if (i > start && candidates[i] == candidates[i - 1]) { continue; }
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
