import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n binary grid grid where each 1 marks the home of one friend, return the minimal total travel distance.
 * The total travel distance is the sum of the distances between the houses of the friends and the meeting point.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * Example 1:
 * Input: grid = [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * Output: 6
 * Explanation: Given three friends living at (0,0), (0,4), and (2,2).
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 is minimal.
 * So return 6.
 *
 * Example 2:
 * Input: grid = [[1,1]]
 * Output: 1
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * grid[i][j] is either 0 or 1.
 * There will be at least two friends in the grid.
 */
public class Problem296 {

    /**
     * Method to fetch smallest dist for all houses in the grid
     * Min distance is always at the middle
     *
     * Time Complexity: O(M * N)
     * Space Complexity: O(M + N)
     *
     * @param grid
     * @return
     */
    private static int minTotalDistance(int[][] grid) {
        List<Integer> rows = getRows(grid);
        List<Integer> cols = getCols(grid);

        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);

        return minDistance(rows, row) + minDistance(cols, col);
    }

    /**
     * Min dist is always at the middle
     *
     * @param points
     * @param mid
     * @return
     */
    private static int minDistance(List<Integer> points, int mid) {
        int sum = 0;
        for (int p : points) {
            sum += Math.abs(p - mid);
        }
        return sum;
    }

    /**
     * Method to get all rows with houses
     *
     * @param grid
     * @return
     */
    private static List<Integer> getRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }
        return rows;
    }

    /**
     * Method to get all cols with houses
     * Notice: reverse order to traverse grid -- list needs to have cols in sorted manner
     *
     * @param grid
     * @return
     */
    private static List<Integer> getCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    cols.add(j);
                }
            }
        }
        return cols;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(minTotalDistance(grid));
    }
}
