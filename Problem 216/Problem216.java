import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the
 * combinations may be returned in any order.
 *
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 *
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 *
 * Example 3:
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there
 * are no valid combination.
 *
 * Example 4:
 * Input: k = 3, n = 2
 * Output: []
 * Explanation: There are no valid combinations.
 *
 * Example 5:
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 * Explanation:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
 * There are no other valid combinations.
 *
 * Constraints:
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class Problem216 {

    /**
     * Method to get all combination sums given constraint of k
     *
     * Time Complexity: O(P(9, k) * K)
     * Space Complexity: O(K)
     *
     * @param k
     * @param n
     * @return
     */
    private static List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n > 45) { return new ArrayList<>(); }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, k, 0, n);
        return res;
    }

    /**
     * Backtracking approach
     *
     * @param res
     * @param list
     * @param index
     * @param k
     * @param sum
     * @param n
     */
    private static void dfs(List<List<Integer>> res, List<Integer> list, int index, int k, int sum, int n) {
        if (k < 0 || sum > n) { return; }
        if (k == 0 && sum == n) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i <= 9; i++) {
            list.add(i);
            dfs(res, list, i + 1, k - 1, sum + i, n);
            list.remove(list.size() - 1);
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 9, k = 3;
        System.out.println(combinationSum3(k, n));
    }
}
