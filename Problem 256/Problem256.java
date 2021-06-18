import java.util.Arrays;

/**
 * There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of
 * painting each house with a certain color is different. You have to paint all the houses such that no two adjacent
 * houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
 *
 * For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting
 * house 1 with color green, and so on...
 * Return the minimum cost to paint all houses.
 *
 * Example 1:
 * Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 *
 * Example 2:
 * Input: costs = [[7,6,2]]
 * Output: 2
 *
 * Constraints:
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 */
public class Problem256 {

    /**
     * Method to get min cost to paint all houses with different colors
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param cost
     * @return
     */
    private static int minCost(int[][] cost) {
        if (cost.length == 0) { return 0; }

        for (int i = cost.length - 2; i >= 0; i--) {
            cost[i][0] += Math.min(cost[i + 1][1], cost[i + 1][2]);
            cost[i][1] += Math.min(cost[i + 1][0], cost[i + 1][2]);
            cost[i][2] += Math.min(cost[i + 1][0], cost[i + 1][1]);
        }

        return Arrays.stream(cost[0]).min().getAsInt();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] cost = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(cost));
    }
}
