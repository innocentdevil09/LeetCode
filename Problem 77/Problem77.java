import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Problem77 {

    /**
     * Backtracking approach to get all combinations
     *
     * @param n
     * @param k
     * @return
     */
    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    /**
     * Backtracking approach to add all combinations of numbers to the result list
     *
     * just a little change it will save a lot of time.
     * i <= n -k + 1, don't use i <= n
     *
     * @param result
     * @param list
     * @param n
     * @param k
     * @param start
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> list, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i <= n - k + 1; i++) {
                list.add(i);
                backtrack(result, list, n, k - 1, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 6, k = 3;

        System.out.println(combine(n, k));
    }
}
