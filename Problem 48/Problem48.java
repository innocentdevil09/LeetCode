/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT
 * allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * Example 3:
 * Input: matrix = [[1]]
 * Output: [[1]]
 *
 * Example 4:
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 *
 * Constraints:
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class Problem48 {

    /**
     * The approach to rotate the matrix is essentially just a trick!
     * 1. Reverse all the rows
     * 2. swap integers in the matrix with reflection across the line: "y = -x + m"
     *
     * @param matrix
     */
    private static void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int[] ints : matrix) {
            reverse(ints, 0, cols - 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - i; j++) {
                swapMatrix(matrix, i, j, cols - 1 - j, rows - 1 - i);
            }
        }
    }

    /**
     * Method to swap integers in matrix
     *
     * @param matrix
     * @param i1
     * @param j1
     * @param i2
     * @param j2
     */
    private static void swapMatrix(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    /**
     * Method to reverse elements in a given row
     *
     * @param row
     * @param lo
     * @param hi
     */
    private static void reverse(int[] row, int lo, int hi) {
        while (lo < hi) {
            swap(row, lo, hi);
            lo++;
            hi--;
        }
    }

    /**
     * Method to swap integers
     *
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        rotate(matrix);
        for (int[] rows : matrix) {
            for (int col : rows) {
                System.out.print(col + " | ");
            }
            System.out.print("\n");
        }
    }
}
