import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer
 * with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * Constraints:
 * 1 <= n <= 10^4
 */
public class Problem279 {

    /*
    Looking at the recursive solution below, the algo looks like this:
    count(i) = 1 + count(i - sq) ∃sq ∈{square numbers}

    private static int numSquares(int n) {
        if (n == 0) { return 0; }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
            dp[i * i] = 1;
        }

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int sq : squares) {
                if (i < sq) { break; }
                dp[i] = Math.min(dp[i], dp[i - sq] + 1);
            }
        }
        return dp[n];
    }
     */

    /**
     * Recursive approach to get min count
     * Algo: count(i) = 1 + count(i - sq) ∃sq ∈{square numbers}
     *
     * Time Complexity: O(N * _/N)
     * Space Complexity: O(_/N)
     *
     * @param n
     * @return
     */
    private static int numSquares(int n) {
        Set<Integer> square_nums = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            square_nums.add(i * i);
        }

        int count = 1;
        for ( ; count <= n; count++) {
            if (isDividedBy(n, count, square_nums)) {
                return count;
            }
        }
        return count;
    }

    /**
     * Recursive method to check if the given number could be attained by summing up the given squares
     *
     * @param n
     * @param count
     * @param square_nums
     * @return
     */
    private static boolean isDividedBy(int n, int count, Set<Integer> square_nums) {
        if (n < 1) { return false; }
        if (count == 1) {
            return square_nums.contains(n);
        }

        for (int sq : square_nums) {
            if (isDividedBy(n - sq, count - 1, square_nums)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }
}
