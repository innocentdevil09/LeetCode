import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Problem54 {

    /**
     * Method to solve spiral order list
     *
     * @param matrix
     * @return
     */
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0, col = 0;
        while (true) {
            boolean isBreak = true;
            while (col < n - 1 && matrix[row][col + 1] != Integer.MIN_VALUE) {
                list.add(matrix[row][col]);
                matrix[row][col] = Integer.MIN_VALUE;
                col++;
                isBreak = false;
            }
            while (row < m - 1 && matrix[row + 1][col] != Integer.MIN_VALUE) {
                list.add(matrix[row][col]);
                matrix[row][col] = Integer.MIN_VALUE;
                row++;
                isBreak = false;
            }
            while (col > 0 && matrix[row][col - 1] != Integer.MIN_VALUE) {
                list.add(matrix[row][col]);
                matrix[row][col] = Integer.MIN_VALUE;
                col--;
                isBreak = false;
            }
            while (row > 0 && matrix[row - 1][col] != Integer.MIN_VALUE) {
                list.add(matrix[row][col]);
                matrix[row][col] = Integer.MIN_VALUE;
                row--;
                isBreak = false;
            }
            if (isBreak) { break; }
        }
        list.add(matrix[row][col]);
        return list;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(spiralOrder(matrix));
    }
}
