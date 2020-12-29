/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes
 * the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Example 2:
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class Problem64 {

    /**
     * The concept to calculate minimum path is highlighted in Prim's and Kruksal's algorithm.
     * In both the algorithms, the key concept remains of relaxing the node in graph such that the other adjoining
     * edges cannot relax it further and it has the minimum weight.
     *
     * Using the same concept, and dynamic programming -- we solve this problem
     *
     * @param grid
     * @return
     */
    private static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                if (i > 0) {
                    min = Math.min(min, grid[i][j] + grid[i - 1][j]);
                }
                if (j > 0) {
                    min = Math.min(min, grid[i][j] + grid[i][j - 1]);
                }
                grid[i][j] = (min == Integer.MAX_VALUE) ? grid[i][j] : min;
            }
        }
        return grid[m - 1][n -1];
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(minPathSum(grid));
    }
}
