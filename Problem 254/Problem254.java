import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as the product of their factors.
 *
 * For example, 8 = 2 x 2 x 2 = 2 x 4.
 * Given an integer n, return all possible combinations of its factors. You may return the answer in any order.
 * Note that the factors should be in the range [2, n - 1].
 *
 * Example 1:
 * Input: n = 1
 * Output: []
 *
 * Example 2:
 * Input: n = 12
 * Output: [[2,6],[3,4],[2,2,3]]
 *
 * Example 3:
 * Input: n = 37
 * Output: []
 *
 * Example 4:
 * Input: n = 32
 * Output: [[2,16],[4,8],[2,2,8],[2,4,4],[2,2,2,4],[2,2,2,2,2]]
 *
 * Constraints:
 * 1 <= n <= 10^7
 */
public class Problem254 {

    /**
     * DFS approach. Start with 2 and get all factors (with combinations) possible
     *
     * Time Complexity: O(2 ^ N)
     * Space Complexity: O(2 ^ N)
     *
     * @param n
     * @return
     */
    private static List<List<Integer>> getFactors(int n) {
        if (n <= 1) { return new ArrayList<>(); }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), n);
        return res;
    }

    /**
     * DFS traversal to get all factors
     *
     * @param res
     * @param list
     * @param n
     */
    private static void dfs(List<List<Integer>> res, List<Integer> list, int n) {
        if (n <= 1) { return; }

        int factor = list.isEmpty() ? 2 : list.get(list.size() - 1);
        for (int i = factor; i * i <= n; i++) {
            if (n % i != 0) { continue; }
            list.add(i);
            dfs(res, list, n / i);
            list.add(n / i);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 32;
        System.out.println(getFactors(n));
    }
}
