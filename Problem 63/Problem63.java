/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 * Example 1:
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Example 2:
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1
 */
public class Problem63 {

    /**
     * Approach:
     * --------
     *
     * 1. If the first cell i.e. obstacleGrid[0,0] contains 1, this means there is an obstacle in the first cell. Hence
     * the robot won't be able to make any move and we would return the number of ways as 0.
     * 2. Otherwise, if obstacleGrid[0,0] has a 0 originally we set it to 1 and move ahead.
     * 3. Iterate the first row. If a cell originally contains a 1, this means the current cell has an obstacle and
     * shouldn't contribute to any path. Hence, set the value of that cell to 0. Otherwise, set it to the value of
     * previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i,j-1]
     * 4. Iterate the first column. If a cell originally contains a 1, this means the current cell has an obstacle and
     * shouldn't contribute to any path. Hence, set the value of that cell to 0. Otherwise, set it to the value of
     * previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i-1,j]
     * 5. Now, iterate through the array starting from cell obstacleGrid[1,1]. If a cell originally doesn't contain any
     * obstacle then the number of ways of reaching that cell would be the sum of number of ways of reaching the cell
     * above it and number of ways of reaching the cell to the left of it.
     *  obstacleGrid[i,j] = obstacleGrid[i-1,j] + obstacleGrid[i,j-1]
     * 6. If a cell contains an obstacle set it to 0 and continue. This is done to make sure it doesn't contribute to
     * any other path.
     *
     * @param obstacleGrid
     * @return
     */
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) { return 0; }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;

        for (int col = 1; col < n; col++) {
            obstacleGrid[0][col] = (obstacleGrid[0][col] == 0 && obstacleGrid[0][col - 1] == 1) ? 1 : 0;
        }
        for (int row = 1; row < m; row++) {
            obstacleGrid[row][0] = (obstacleGrid[row][0] == 0 && obstacleGrid[row - 1][0] == 1) ? 1: 0;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (obstacleGrid[row][col] == 1) {
                    obstacleGrid[row][col] = 0;
                } else {
                    obstacleGrid[row][col] = obstacleGrid[row][col - 1] + obstacleGrid[row - 1][col];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
