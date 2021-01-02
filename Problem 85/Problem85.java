import java.util.Arrays;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and
 * return its area.
 *
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 *
 * Example 2:
 * Input: matrix = []
 * Output: 0
 *
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * Example 4:
 * Input: matrix = [["1"]]
 * Output: 1
 *
 * Example 5:
 * Input: matrix = [["0","0"]]
 * Output: 0
 *
 * Constraints:
 * rows == matrix.length
 * cols == matrix.length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'
 */
public class Problem85 {

    /**
     * THIS IS A LONG EXPLANATION
     *
     * Short version :
     * --------------
     * -- height means from top to this position, there are how many '1'
     * -- left means at current position, what is the index of left bound of the rectangle with height[j]. 0 means at
     * this position, no rectangle.
     * -- right means the right bound index of this rectangle. 'n' means no rectangle.
     *
     * matrix
     * 0 0 0 1 0 0 0
     * 0 0 1 1 1 0 0
     * 0 1 1 1 1 1 0
     *
     * height
     * 0 0 0 1 0 0 0
     * 0 0 1 2 1 0 0
     * 0 1 2 3 2 1 0
     *
     * left
     * 0 0 0 3 0 0 0
     * 0 0 2 3 2 0 0
     * 0 1 2 3 2 1 0
     *
     * right
     * 7 7 7 4 7 7 7
     * 7 7 5 4 5 7 7
     * 7 6 5 4 5 4 7
     *
     * result
     * 0 0 0 1 0 0 0
     * 0 0 3 2 3 0 0
     * 0 5 6 3 6 5 0
     *
     * Long version :
     * --------------
     * we start from the first row, and move downward;
     *  * height[j] record the current number of continuous '1' in column j;
     *  * left[j] record the left most index j which satisfies that for any index k from j to  i, height[k] >=
     *  height[j];
     *  * right[j] record the right most index j which satisfies that for any index k from i to  j, height[k] >=
     *  height[j];
     *  * by understanding the definition, we can easily figure out we need to update maxArea with value (height[j] *
     *  (right[j] - left[j] + 1));
     *  *
     *  * Then the question is how to update the array of height, left, and right
     *  * =================================
     *  * for updating height, it is easy
     *  * for (int j = 0; j < n; j++) {
     *  *    if (matrix[i][j] == '1') height[j]++;
     *  *    else height[j] = 0;
     *  * }
     *  * =============================================================================
     *  * It is a little bit tricky for initializing and updating left and right array
     *  * for initialization:
     *  * we know initially, height array contains all 0, so according to the definition of left and right array,
     *  left array should contains all 0, and right array should contain all n - 1
     *  * for updating left and right, it is kind of tricky to understand...
     *  *     ==============================================================
     *  *     Here is the code for updating left array, we scan from left to right
     *  *     int lB = 0;  //lB is indicating the left boundry for the current row of the matrix (for cells with char
     *  "1"), not the height array...
     *  *     for (int j = 0; j < n; j++) {
     *  *          if (matrix[i][j] == '1') {
     *  *              left[j] = Math.max(left[j], lB); // this means the current boundry should satisfy two
     *  conditions: within the boundry of the previous height array, and within the boundry of the current row...
     *  *          } else {
     *  *              left[j] = 0; // when matrix[i][j] = 0, height[j] will get update to 0, so left[j] becomes 0,
     *  since all height in between 0 - j satisfies the condition of height[k] >= height[j];
     *  *              lB = j + 1; //and since current position is '0', so the left most boundry for next "1" cell is
     *  at least j + 1;
     *  *          }
     *  *     }
     *  *     ==============================================================
     *  *     the idea for updating the right boundary is similar, we just need to iterate from right to left
     *  *     int rB = n - 1;
     *  *     for (int j = n - 1; j >= 0; j--) {
     *  *         if (matrix[i][j] == '1') {
     *  *              right[j] = Math.min(right[j], rB);
     *  *         } else {
     *  *              right[j] = n - 1;
     *  *              rB = j - 1;
     *  *      }
     *
     * @param matrix
     * @return
     * */

    private static int maximalRectangle(char[][] matrix) {
        if (matrix == null) { return 0; }
        int m = matrix.length;
        if (m == 0) { return 0; }
        int n = matrix[0].length;
        if (n == 0) { return 0; }

        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n - 1);
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            updateHeightsArray(height, matrix, i, n);
            updateLeftArray(left, matrix, i, n);
            updateRightArray(right, matrix, i, n);

            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j] + 1) * height[j]);
            }
        }
        return maxArea;
    }

    /**
     * height[j] record the current number of continuous '1' in column j
     *
     * @param height
     * @param matrix
     * @param i
     * @param n
     */
    private static void updateHeightsArray(int[] height, char[][] matrix, int i, int n) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == '1') {
                height[j]++;
            } else {
                height[j] = 0;
            }
        }
    }

    /**
     * left[j] record the left most index j which satisfies that for any index k from j to  i, height[k] >= height[j]
     *
     * @param left
     * @param matrix
     * @param i
     * @param n
     */
    private static void updateLeftArray(int[] left, char[][] matrix, int i, int n) {
        int lpointer = 0;
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == '0') {
                left[j] = 0;
                lpointer = j + 1;
            } else if (matrix[i][j] == '1') {
                left[j] = Math.max(left[j], lpointer);
            }
        }
    }

    /**
     * right[j] record the right most index j which satisfies that for any index k from i to  j, height[k] >= height[j]
     *
     * @param right
     * @param matrix
     * @param i
     * @param n
     */
    private static void updateRightArray(int[] right, char[][] matrix, int i, int n) {
        int rpointer = n - 1;
        for (int j = n - 1; j >= 0; j--) {
            if (matrix[i][j] == '0') {
                right[j] = n - 1;
                rpointer = j - 1;
            } else if (matrix[i][j] == '1') {
                right[j] = Math.min(right[j], rpointer);
            }
        }
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        char[][] matrix = new char[][]
                {{'1','0','1','0','0'},
                 {'1','0','1','1','1'},
                 {'1','1','1','1','1'},
                 {'1','0','0','1','0'}};

        System.out.println(maximalRectangle(matrix));
    }
}
