/**
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 */
public class Problem73 {

    /**
     * Method to set entire row and col in the matrix as 0, for indices where the element is 0
     *
     * @param matrix
     */
    private static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        boolean colZero = false;
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) {
                colZero = true;
            }
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) { setRowZero(matrix, 0); }
        if (colZero) { setColZero(matrix, 0); }
    }

    /**
     * Method to set all elements in the given row of the matrix as zero
     *
     * @param matrix
     * @param row
     */
    private static void setRowZero(int[][] matrix, int row) {
        int m = matrix.length, n = matrix[0].length;

        for (int col = 0; col < n; col++) {
            matrix[row][col] = 0;
        }
    }

    /**
     * Method to set all elements in the given col of the matrix as zero
     *
     * @param matrix
     * @param col
     */
    private static void setColZero(int[][] matrix, int col) {
        int m = matrix.length, n = matrix[0].length;

        for (int row = 0; row < m; row++) {
            matrix[row][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};

        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " | ");
            }
            System.out.print("\n");
        }
    }
}
