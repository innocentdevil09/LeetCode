import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house
 * with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same
 * color.
 *
 * The cost of painting each house with a certain color is represented by an n x k cost matrix costs.
 *
 * For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1
 * with color 2, and so on...
 * Return the minimum cost to paint all houses.
 *
 * Example 1:
 * Input: costs = [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation:
 * Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 * Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 *
 * Example 2:
 * Input: costs = [[1,3],[2,4]]
 * Output: 5
 *
 * Constraints:
 * costs.length == n
 * costs[i].length == k
 * 1 <= n <= 100
 * 1 <= k <= 20
 * 1 <= costs[i][j] <= 20
 *
 * Follow up: Could you solve it in O(nk) runtime?
 */
public class Problem265 {

    /**
     * Method to paint houses with different adjacent colors
     * Need two vars to calculate min and secondMin cost to get correct answer. The reason is -- we can't take the
     * one which is directly below the minimum as that would break the adjacency rule. Therefore we take a secondMin
     *
     * Time Complexity: O(N*K)
     * Space Complexity: O(1)
     *
     * @param costs
     * @return
     */
    private static int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) { return 0; }
        int n = costs.length;
        int k = costs[0].length;

        for (int i = n - 2; i >= 0; i--) {
            int min = -1, secondMin = -1;
            for (int j = 0; j < k; j++) {
                int cost = costs[i + 1][j];
                if (min == -1 || cost < costs[i + 1][min]) {
                    secondMin = min;
                    min = j;
                } else if (secondMin == -1 || cost < costs[i + 1][secondMin]) {
                    secondMin = j;
                }
            }

            for (int j = 0; j < k; j++) {
                costs[i][j] += (j == min) ? costs[i + 1][secondMin] : costs[i + 1][min];
            }
        }

        return Arrays.stream(costs[0]).min().getAsInt();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] costs = {{1,5,3},{2,9,4}};
        System.out.println(minCostII(costs));
    }
}
