/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 * 1 <= n <= 45
 */
public class Problem70 {

    /**
     * Dynamic programming
     * The trick is to find the pattern -- for any given stair number 'n', we can reach to it from either 'n - 1'
     * stair or 'n - 2' stair. Therefore the total number of ways to reach stair 'n' is sum of 'n - 1' & 'n - 2'
     *
     * Can also use fibonacci sequence to save on space complexity
     *
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        int[] dp = new int[n + 2]; // n + 2 to handle ArrayIndexOutOfBounds for n = 1
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 67;

        System.out.println(climbStairs(n));
    }
}
