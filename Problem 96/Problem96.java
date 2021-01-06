/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 * Constraints:
 * 1 <= n <= 19
 */
public class Problem96 {

    /**
     * Realised the importance of dp approach to solve the generateTrees problem, when i came across this question.
     * This could be solved only if you understood the dp approach to generate unique BST's for a given n (Problem 95)
     *
     * @param n
     * @return
     */
    private static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;

        System.out.println(numTrees(n));
    }
}
