import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 * Constraints:
 * 0 <= rowIndex <= 33
 *
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */
public class Problem119 {

    /**
     * Method to fetch exact row in a growing pascal's triangle
     * DP and memoization
     *
     * Time Complexity : O(rowIndex^2)
     * Space Complexity: O(rowIndex^2)
     *
     * @param rowIndex
     * @return
     */
    private static List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= rowIndex; j++) {
                if (i == 0 || i == j) {
                    dp[i][j] = 1;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int j = 0; j <= rowIndex; j++) {
            res.add(getElement(rowIndex, j, dp));
        }
        return res;
    }

    /**
     * Recursive method that uses memoization to fetch elements at a given rowIndex
     *
     * @param i
     * @param j
     * @param dp
     * @return
     */
    private static int getElement(int i, int j, int[][] dp) {
        if (i == 0 || j == 0 || i == j) { return 1; }

        if (dp[i][j] != 0) { return dp[i][j]; }
        int ans = getElement(i - 1, j, dp) + getElement(i - 1, j - 1, dp);
        dp[i][j] = ans;
        return ans;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int rowIndex = 5;
        System.out.println(getRow(rowIndex));
    }
}
