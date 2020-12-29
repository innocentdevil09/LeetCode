import java.util.stream.IntStream;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 * Example 3:
 * Input: m = 7, n = 3
 * Output: 28
 *
 * Example 4:
 * Input: m = 3, n = 3
 * Output: 6
 *
 * Constraints:
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10^9
 */
public class Problem62 {

    /**
     * Approach 1:
     * -----------
     * I used a dfs approach to solve the given problem. Created a boolean[] array with length (m * n), and for each
     * entry at a given row and col -- i would run dfs again for (row - 1, col) && (row, col + 1).
     * To retrieve the count, created an array with length 1: count[1], and kept incrementing it.
     *
     * This approach gave me "Time Limit Exceeded" error.
     *
     * Approach 2:
     * -----------
     * Reduced the problem to a dp problem.
     * Created a matrix board, and kept increasing the values based on the neighbouring cells.
     *
     * Alternatively: We can optimise it to a great degree, and reduce the space complexity to O(n)
     *
     * @param m
     * @param n
     * @return
     */
    private static int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        board[0][0] = 0;
        IntStream.range(1, n).forEach(col -> board[m - 1][col] = 1);
        IntStream.range(0, m - 1).forEach(row -> board[row][0] = 1);

        for (int row = m - 2; row >= 0; row--) {
            for (int col = 1; col < n; col++) {
                if (board[row][col] != 0) { continue; }
                board[row][col] = board[row + 1][col] + board[row][col - 1];
            }
        }

        return board[0][n - 1];
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int m = 23, n = 12;

        System.out.println(uniquePaths(m, n));
    }
}
