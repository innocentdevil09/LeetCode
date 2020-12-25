import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each
 * other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example 1:
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= n <= 9
 */
public class Problem52 {

    /**
     * Method to solve n-queens problem using constraints and backtracking approach
     *
     * Time complexity: O(N!)
     *
     * @param n
     * @return
     */
    private static int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        List<List<String>> result = new ArrayList<>();
        int[] rows = new int[n];
        backtrack(result, rows, 0, cols, diag1, diag2);
        System.out.println(result);
        return result.size();
    }

    /**
     * The approach involves putting restrictions after each queen placement. One puts a queen on the board and that
     * immediately excludes one column, one row and two diagonals for the further queens placement. That propagates
     * constraints and helps to reduce the number of combinations to consider.
     *
     * 1. Start from the first row = 0.
     *
     * 2. Iterate over the columns and try to put a queen in each column.
     *
     * 3. If square (row, column) is not under attack
     *      Place the queen in (row, column) square.
     *      Exclude one row, one column and two diagonals from further consideration.
     * 4. If all rows are filled up row == N
     *      That means that we find out one more solution.
     * 5. Else
     *      Proceed to place further queens backtrack(row + 1).
     * 6. Now backtrack : remove the queen from (row, column) square.
     *
     * @param result
     * @param rows
     * @param row
     * @param cols
     * @param diag1
     * @param diag2
     */
    private static void backtrack(List<List<String>> result, int[] rows, int row, Set<Integer> cols,
            Set<Integer> diag1, Set<Integer> diag2) {
        int n = rows.length;
        if (row == n) {
            //add elements of board into result
            addToResult(result, rows);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col)) { continue; }

            int diagonal1 = row + col;
            if (diag1.contains(diagonal1)) { continue; }

            int diagonal2 = row - col;
            if (diag2.contains(diagonal2)) { continue; }

            rows[row] = col;
            cols.add(col);
            diag1.add(diagonal1);
            diag2.add(diagonal2);
            backtrack(result, rows, row + 1, cols, diag1, diag2);

            cols.remove(col);
            diag1.remove(diagonal1);
            diag2.remove(diagonal2);
        }
    }

    /**
     * While looking at this particular method, could not help but notice that the diagonals are following a pattern.
     * They are either (row + col = const) OR (row - col = const)
     * We can use this info to solve the given problem in a more efficient way
     */
    //    private static void markSpaces(String[][] board, int row, int col, String mark) {
//        int n = board.length;
//        for (int k = 0; k < n; k++) {
//            board[row][k] = mark;
//            board[k][col] = mark;
//        }
//
//        int i = row, j = col;
//        while (i < n && j < n) {
//            board[i][j] = mark;
//            i += 1;
//            j += 1;
//        }
//        i = row; j = col;
//
//        while (i >= 0 && j < n) {
//            board[i][j] = mark;
//            i -= 1;
//            j += 1;
//        }
//        i = row; j = col;
//
//        while (i >= 0 && j >= 0) {
//            board[i][j] = mark;
//            i -= 1;
//            j -= 1;
//        }
//        i = row; j = col;
//
//        while (i < n && j >= 0) {
//            board[i][j] = mark;
//            i += 1;
//            j -= 1;
//        }
//        board[row][col] = mark;
//    }

    /**
     * Add all elements of the given board into the result as a list
     *
     * @param result
     * @param rows
     */
    private static void addToResult(List<List<String>> result, int[] rows) {
        int n = rows.length;
        char[] arr = new char[n];
        Arrays.fill(arr, '.');
        List<String> list = new ArrayList<>();
        for (int row : rows) {
            arr[row] = 'Q';
            list.add(String.valueOf(arr));
            arr[row] = '.';
        }
        result.add(list);
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 4;

        System.out.println(totalNQueens(n));
    }
}
