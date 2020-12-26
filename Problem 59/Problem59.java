/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example 1:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= n <= 20
 */
public class Problem59 {

    /**
     * Method to generate matrix in spiral order
     *
     * @param n
     * @return
     */
    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int counter = 1;
        int row = 0, col = 0;

        while (true) {
            boolean isBreak = true;
            while (col < n - 1 && matrix[row][col + 1] == 0) {
                matrix[row][col] = counter++;
                col++;
                isBreak = false;
            }
            while (row < n - 1 && matrix[row + 1][col] == 0) {
                matrix[row][col] = counter++;
                row++;
                isBreak = false;
            }
            while (col > 0 && matrix[row][col - 1] == 0) {
                matrix[row][col] = counter++;
                col--;
                isBreak = false;
            }
            while (row > 0 && matrix[row - 1][col] == 0) {
                matrix[row][col] = counter++;
                row--;
                isBreak = false;
            }
            if (isBreak) { break; }
        }
        matrix[row][col] = counter;
        return matrix;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;

        int[][] matrix = generateMatrix(n);
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " | ");
            }
            System.out.print("\n");
        }
    }
}
