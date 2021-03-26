/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy
 * again).
 *
 * Example 1:
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at
 * the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Example 4:
 * Input: prices = [1]
 * Output: 0
 *
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 */
public class Problem123 {

    /**
     * Using an Approach for generalised k transactions..
     * t = number of transactions .. from 0 to k
     * d = number of days for which prices are given..
     * Create an array... dp[t][d]
     * which represents the max profit at day d, using t transactions until that day..
     *
     * base cases.. We can make 0 profit using 0 transactions, so dp[0] [...d...] will be 0.
     * Also base case... we can make 0 profit by making 1,2,3,.. k transactions on the first day, so first col is
     * also 0.
     * Now at any dp[t][d] there are 2 cases..
     * 3.a) Either we have made t transactions till d-1 day.. so one candidate of max profit comparison is dp[t][d-1]
     * 3.b) Or we have made t-1 transactions before any day d -> say day x, and we make one more transaction by
     * buying on that day(ie. buy on day x) and selling on day d.. the profit by doing this would be = profit made
     * until that day x (which represents profit of t-1 tx until day x) + the profit made by latest tx -> price[d] -
     * price[x]
     *
     * Time Complexity : O(nk)
     * Space Complexity : O(nk)
     *
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        if (prices.length == 0) { return 0; }
        int k = 2, n = prices.length;
        int[][] dp = new int[k + 1][n];

        for (int i = 1; i < k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], max + prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }
}
