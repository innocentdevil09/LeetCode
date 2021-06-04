/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy
 * again).
 *
 * Example 1:
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 *
 * Example 2:
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price =
 * 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 * Constraints:
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 */
public class Problem188 {

    /**
     * Dynamic Programming
     * Base condition: Need to maximise the profit, therefore need to keep a tab on the minimum price that could be
     * available till that day -- that could lead to maximum profit
     * As the value of k increases, i.e. the number of transactions allowed increases, the value of min gets modified
     * to account for previous transactions. If there is a possibility to maximise the overall profit, the min
     * variable becomes negative and adds on to the profit in the later transactions
     *
     * Time Complexity: O(k * N)
     * Space Complexity: O(k * N)
     *
     * @param k
     * @param prices
     * @return
     */
    private static int maxProfit(int k, int[] prices) {
        if (prices.length == 0) { return 0; }
        int n = prices.length;
        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {
            int min = prices[0];
            for (int j = 1; j < n; j++) {
                min = Math.min(min, prices[j] - dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
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
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }
}
